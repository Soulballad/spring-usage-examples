package com.soulballad.usage.springcloud.service.feign;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.soulballad.usage.springcloud.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign
 * @since ：2020/6/23 22:11
 */
@FeignClient("${provider.application.name}")
@DubboTransported(protocol = "dubbo")
public interface DubboFeignService {

    @GetMapping(value = "/param")
    String param(@RequestParam("param") String param);

    @PostMapping(value = "/params")
    String params(@RequestParam("a") Integer a, @RequestParam("b") String b);

    @GetMapping(value = "/headers")
    String headers(@RequestHeader("h1") String header1, @RequestHeader("h2") String header2, @RequestParam("val") Integer param);

    @GetMapping(value = "/pathVariables/{p1}/{p2}")
    String pathVariables(@PathVariable("p1") String path1, @PathVariable("p2") String path2, @RequestParam("val") String param);

    @PostMapping(value = "/request/body/map")
    UserModel requestBodyMap(@RequestBody Map<String, Object> data, @RequestParam("param") String param);
}
