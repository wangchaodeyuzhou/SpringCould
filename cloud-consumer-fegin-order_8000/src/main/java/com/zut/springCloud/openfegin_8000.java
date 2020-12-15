package com.zut.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud
 * @date 2020/11/17 18:49
 */
@SpringBootApplication
@EnableFeignClients
public class openfegin_8000 {
    public static void main(String[] args) {
        SpringApplication.run(openfegin_8000.class,args);
    }
}

