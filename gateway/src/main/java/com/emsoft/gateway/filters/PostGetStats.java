package com.emsoft.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostGetStats extends ZuulFilter
{

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 21;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {


        int code = RequestContext.getCurrentContext().getResponseStatusCode();
        System.out.print("PostGetStats   "+code);
        return null;
    }
}
