package com.zut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud
 * @date 2020/12/19 12:19
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8802.class,args);
    }
}
