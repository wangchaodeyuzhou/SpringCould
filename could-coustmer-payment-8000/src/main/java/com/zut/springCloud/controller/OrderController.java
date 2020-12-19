package com.zut.springCloud.controller;


import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import com.zut.springCloud.lb.LoadBaser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //搞得集群试一试 这个添写Eureka注册的服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private   RestTemplate restTemplate;//读操作用get，写操作用psot

    @Resource
    private LoadBaser loadBaser;

    @Resource
    private DiscoveryClient discoveryClient;
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
    @GetMapping("/customer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
         if (instances == null ||instances.size()<=0) return null;
         else {

            ServiceInstance serviceInstance = loadBaser.instances(instances);
             URI uri = serviceInstance.getUri();
             return restTemplate.getForObject(uri+"/payment/lb",String.class);
         }
    }

    @GetMapping("/comsumer/payment/zikpin")
    public String paymentZipKin(){
        String result = restTemplate.getForObject("http://localhost:8001"+"payment/zikpin",String.class);
        return result;
    }
}
