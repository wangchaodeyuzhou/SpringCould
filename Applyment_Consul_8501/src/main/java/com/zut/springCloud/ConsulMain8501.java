package com.zut.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain8501 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain8501.class, args);
    }
}
