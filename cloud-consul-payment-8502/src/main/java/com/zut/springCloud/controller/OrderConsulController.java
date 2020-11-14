package com.zut.springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOK_URI = "http://cloud-provider-payment-consul";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/customer/payment/consul")
    public String MyConsul(){
        log.info("customer 利用RestTemplate调用远程的服务");
        return restTemplate.getForObject(INVOK_URI+"/payment/consul",String.class);
    }
}
