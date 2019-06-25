package com.yijiankang.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义网关过滤器
 */
public class Filter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(Filter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info("send{} request to {}",httpServletRequest.getMethod(),httpServletRequest.getRequestURL().toString());
        String type = httpServletRequest.getParameter("type");
        if(type==null){
            logger.warn("type is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("type is ok");
        return null;
    }
}
