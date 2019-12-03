package com.hgz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author LuoWei
 * @Date 2019/12/3
 */
@Component
@Slf4j
public class MyzuulFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        //RequestContext用于再过滤器之间传递消息，它的数据保存在每个请求的threadlocal中
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("拦截请求："+request.getRequestURI());
        String token = request.getParameter("token");
        if (token==null||"".equals(token.trim())){
            //此处让请求不再往下发
            ctx.setSendZuulResponse(false);
            //给客户端响应信息
            try {
                ctx.getResponse().getWriter().print("Token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
