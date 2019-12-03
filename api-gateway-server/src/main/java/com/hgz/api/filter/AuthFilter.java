package com.hgz.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author LuoWei
 * @Date 2019/12/3
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //ServerWebExchange相当于当前请求和响应的上下文，通过它可以获得request和response对象
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null||"".equals(token)){
            log.info("TOKEN IS NULL");
            //认证不通过
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //指定过滤器的优先级，值越低，优先级越高
        return 0;
    }
}
