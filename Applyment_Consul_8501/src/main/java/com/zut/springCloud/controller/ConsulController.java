package com.zut.springCloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/consul")
    public String ApplymentConsul(){
        log.info("Consul注册服务中心");
        return "SpringCloud with Consul : port : "+  ServerPort +"UUID "+ UUID.randomUUID().toString();
    }
}
