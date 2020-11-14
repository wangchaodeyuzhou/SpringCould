package com.zut.springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String INVOKE_URL = "http://cloud-provider-payment-zookeeper";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/zk")
    public String CustomerZookeeper(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
    }

}
