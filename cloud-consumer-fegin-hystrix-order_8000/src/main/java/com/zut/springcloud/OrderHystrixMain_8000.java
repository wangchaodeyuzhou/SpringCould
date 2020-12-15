package com.zut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud
 * @date 2020/11/25 21:04
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain_8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain_8000.class,args);
    }
}
