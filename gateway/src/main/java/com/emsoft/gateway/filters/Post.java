package com.emsoft.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class Post extends ZuulFilter
{

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return !RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() {

        System.out.print("post");

        return null;
    }
}
