package com.soulballad.usage.springcloud.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : filter
 * @since ：2020/6/5 20:39
 */
@Component
public class AsmFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsmFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        LOGGER.info("AsmFilter get request, request port is {} path is {}", request.getRemoteAddr(),
            request.getRequestURI());
        return null;
    }
}
