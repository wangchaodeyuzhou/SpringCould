package com.zut.springCloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.config
 * @date 2020/12/16 17:27
 */
@Configuration
public class ConfigGateway {
    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
         RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
         routes.route("payment_route_vdsd",
                 r-> r.path("/new")
                 .uri("http://news.baidu.com/new")).build();
        System.out.println("----------我他妈服了你了————————————————");
       return routes.build();
   }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
