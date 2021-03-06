package com.zut.springCloud.controller;

import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import com.zut.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String ServerPort;
    @Resource
    private DiscoveryClient discoveryClient;

     @PostMapping("/payment/create")
     public CommonResult create(@RequestBody Payment payment){
         int result = paymentService.create(payment);
         log.info("-----插入结果： "+ result);
         if (result > 0) return new CommonResult(200,"插入数据库成功,端口号为 "+ServerPort,result);
         else
             return new CommonResult(404,"插入数据库失败",null);
     }
     @GetMapping("/payment/get/{id}")
    public CommonResult select(@PathVariable("id")Long id){
         Payment payment = paymentService.getPaymentById(id);
        log.info("------查询的结果为"+payment+"\t"+" 哈哈哈哈哈哈");
         if(null!=payment) return new CommonResult(200,"查询成功,端口号为 "+ServerPort, payment);
         else return new CommonResult(404,"查询失败",null);
     }

     @GetMapping("/payment/discovery")
    public Object discoveryServer(){
         List<String> services = discoveryClient.getServices();
         for (String service : services) {
             log.info("--------------------service --------------"+ service);
         }
         List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

         for (ServiceInstance instance : instances) {
             log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
         }

         return this.discoveryClient;
     }

     // 手写实现Ribbon轮询

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
         return ServerPort;
    }
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeout(){
        System.out.println("我tm被调用了");
         try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ServerPort;
    }

    // zikpin测试搞一搞

    @GetMapping(value = "/payment/zikpin")
    public String TextZipkin(){
        System.out.println("我他妈的贷记卡多久啊老大");
        return "你迟到了你都v阿拉丁";
    }
}
