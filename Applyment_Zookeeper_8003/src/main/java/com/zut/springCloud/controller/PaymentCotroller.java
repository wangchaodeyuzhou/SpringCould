package com.zut.springCloud.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentCotroller {
   @Value("${server.port}")
    private String ServerPort;
   @RequestMapping("/payment/zk")
   public String paymentzk(){
       log.info("我有点恶心，靠");
       return "SpringCloud with ZK : port :"+ ServerPort +"UUID "+ UUID.randomUUID().toString();
   }
}
