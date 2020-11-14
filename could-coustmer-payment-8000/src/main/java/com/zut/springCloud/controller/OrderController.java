package com.zut.springCloud.controller;

import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //搞得集群试一试 这个添写Eureka注册的服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private   RestTemplate restTemplate;//读操作用get，写操作用psot
    @GetMapping("/customer/payment/create")
    public CommonResult create(Payment payment){
        //这个是请求的服务端的地址
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    @GetMapping("/customer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
      return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class );
    }
    //

    @GetMapping("/customer/payment/getEntity/{id}")
    public CommonResult getEntity(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,
                CommonResult.class);
         if (forEntity.getStatusCode().is2xxSuccessful()){
             return forEntity.getBody();
         }else{
             return new CommonResult(404, "炒作失败");
         }
    }
}
