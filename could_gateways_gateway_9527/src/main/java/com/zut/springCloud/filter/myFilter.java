package com.zut.springCloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.filter
 * @date 2020/12/17 18:40
 */
@Component
@Slf4j
public class myFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("当前时间为: "+ new Date());
        System.out.println("检查用户是否合法");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(null == uname){
            System.out.println("对不起，用户不合法");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 合法就放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
