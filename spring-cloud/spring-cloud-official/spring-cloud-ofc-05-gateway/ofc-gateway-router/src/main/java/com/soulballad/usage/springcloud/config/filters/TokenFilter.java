package com.soulballad.usage.springcloud.config.filters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : token
 * @since ：2020/6/14 19:13
 */
public class TokenFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 只有综合路由才添加这个全局过滤器（routesId：route_all）
        // 如果请求路径中不存在 routeAll 字符串
        if (!request.getURI().toString().contains("routeAll")) {
            return chain.filter(exchange);
        }

        // 从请求中获取 token 参数
        String token = request.getQueryParams().getFirst("token");
        // 如果为空，那么将返回 401
        if (StringUtils.isBlank(token)) {
            JSONObject message = new JSONObject();
            message.put("code", "-1");
            message.put("msg", "the token is needed!");
            // 转换响应消息内容对象为字节
            byte[] bytes = JSON.toJSONString(message).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            // 设置响应对象状态码 401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "text/plain;charset=UTF-8");
            // 返回响应对象
            return response.writeWith(Mono.just(buffer));
        }

        // 获取请求地址
        String beforePath = request.getPath().pathWithinApplication().value();
        // 获取响应状态码
        HttpStatus beforeStatusCode = response.getStatusCode();
        System.out.println("响应码：" + beforeStatusCode + "，请求路径：" + beforePath);
        // 请求前
        System.out.println("filter -> before");
        // 如果不为空，就通过
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // 获取请求地址
            String afterPath = request.getPath().pathWithinApplication().value();
            // 获取响应状态码
            HttpStatus afterStatusCode = response.getStatusCode();
            System.out.println("响应码：" + afterStatusCode + "，请求路径：" + afterPath);
            // 响应后
            System.out.println("filter -> after");
        }));
    }
}
