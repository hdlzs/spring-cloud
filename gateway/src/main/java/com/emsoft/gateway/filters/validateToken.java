package com.emsoft.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class validateToken extends ZuulFilter
{

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

    @Override
    public Object run() {

        System.out.print(1111);
        //RequestContext.getCurrentContext().setSendZuulResponse(false);
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        String Authorization = req.getParameter("Authorization");
        if(Authorization==null){
            Authorization="3333333";
        }
        System.out.println(Authorization);
        RequestContext.getCurrentContext().addZuulRequestHeader("Authorization",Authorization);
        return null;
    }
}
