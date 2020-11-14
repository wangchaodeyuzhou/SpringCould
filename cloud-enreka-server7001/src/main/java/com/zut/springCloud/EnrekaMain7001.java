package com.zut.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EnrekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EnrekaMain7001.class,args);
    }
}
