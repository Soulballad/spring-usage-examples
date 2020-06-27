package com.soulballad.usage.springcloud.gateway;

import com.alibaba.cloud.dubbo.http.MutableHttpServerRequest;
import com.alibaba.cloud.dubbo.metadata.DubboRestServiceMetadata;
import com.alibaba.cloud.dubbo.metadata.RequestMetadata;
import com.alibaba.cloud.dubbo.metadata.RestMethodMetadata;
import com.alibaba.cloud.dubbo.metadata.repository.DubboServiceMetadataRepository;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceExecutionContext;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceExecutionContextFactory;
import com.alibaba.cloud.dubbo.service.DubboGenericServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : gateway
 * @since ：2020/6/26 16:37
 */
@WebServlet(urlPatterns = "/dsc/*")
public class DubboGatewayServlet extends HttpServletBean {

    private final DubboServiceMetadataRepository metadataRepository;

    private final DubboGenericServiceFactory serviceFactory;

    private final DubboGenericServiceExecutionContextFactory contextFactory;

    private final Map<String, Object> dubboTranslatedAttributes = new HashMap<>();

    public DubboGatewayServlet(DubboServiceMetadataRepository metadataRepository, DubboGenericServiceFactory serviceFactory, DubboGenericServiceExecutionContextFactory contextFactory) {
        this.metadataRepository = metadataRepository;
        this.serviceFactory = serviceFactory;
        this.contextFactory = contextFactory;
        dubboTranslatedAttributes.put("protocol", "dubbo");
        dubboTranslatedAttributes.put("cluster", "failover");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String serviceName = resolveServiceName(req);
        String restPath = StringUtils.substringAfter(req.getRequestURI(), serviceName);
        // init service metadata
        metadataRepository.initializeMetadata(serviceName);
        // build metadata
        RequestMetadata metadata = buildRequestMetadata(req, restPath);

        DubboRestServiceMetadata dubboRestServiceMetadata = metadataRepository.get(serviceName, metadata);
        if (Objects.isNull(dubboRestServiceMetadata)) {
            throw new ServletException("dubboRestServiceMetadata can't be null!");
        }

        RestMethodMetadata restMethodMetadata = dubboRestServiceMetadata.getRestMethodMetadata();
        GenericService genericService = serviceFactory.create(dubboRestServiceMetadata, dubboTranslatedAttributes);
        ServletInputStream inputStream = req.getInputStream();
        byte[] bodyBytes = StreamUtils.copyToByteArray(inputStream);

        MutableHttpServerRequest httpServerRequest = new MutableHttpServerRequest(new HttpRequestAdapter(req), bodyBytes);
        DubboGenericServiceExecutionContext context = contextFactory.create(restMethodMetadata, httpServerRequest);

        Object result = genericService.$invoke(context.getMethodName(), context.getParameterTypes(), context.getParameters());
        res.getWriter().println(result);
    }

    private RequestMetadata buildRequestMetadata(HttpServletRequest req, String restPath) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(req.getRequestURI()).build(true);
        RequestMetadata metadata = new RequestMetadata();
        metadata.setPath(restPath);
        metadata.setMethod(req.getMethod());
        metadata.setParams(getParams(req));
        metadata.setHeaders(getHeaders(req));
        return metadata;
    }

    private Map<String, List<String>> getHeaders(HttpServletRequest req) {
        Map<String, List<String>> map = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(headerName);
            map.put(headerName, Collections.list(headerValues));
        }
        return map;
    }

    private Map<String, List<String>> getParams(HttpServletRequest req) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            map.put(entry.getKey(), Arrays.asList(entry.getValue()));
        }
        return map;
    }

    private String resolveServiceName(HttpServletRequest req) {
        // /g/{app-name}/{rest-path}
        String requestURI = req.getRequestURI();
        // /g/
        String servletPath = req.getServletPath();

        String path = StringUtils.substringAfter(requestURI, servletPath);

        return StringUtils.substringBetween(path, "/", "/");
    }

    private static final class HttpRequestAdapter implements HttpRequest {

        private final HttpServletRequest request;

        private HttpRequestAdapter(HttpServletRequest request) {
            this.request = request;
        }

        @Override
        public String getMethodValue() {
            return request.getMethod();
        }

        @Override
        public URI getURI() {
            try {
                return new URI(request.getRequestURL().toString() + "?" + request.getQueryString());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public HttpHeaders getHeaders() {
            return new HttpHeaders();
        }
    }
}
