package com.zut.springCloud.controller;

import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import com.zut.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String ServerPort;
     @PostMapping("/payment/create")
     public CommonResult create(@RequestBody Payment payment){
         int result = paymentService.create(payment);
         log.info("-----插入结果： "+ result);
         if (result > 0) return new CommonResult(200,"插入数据库成功,端口号为: "+ServerPort,result);
         else
             return new CommonResult(404,"插入数据库失败",null);
     }
     @GetMapping("/payment/get/{id}")
    public CommonResult select(@PathVariable("id")Long id){
         Payment payment = paymentService.getPaymentById(id);
        log.info("------查询的结果为"+payment+"\t"+" 哈哈哈哈哈哈");
         if(null!=payment) return new CommonResult(200,"查询成功端口号为 "+ServerPort, payment);
         else return new CommonResult(404,"查询失败",null);
     }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return ServerPort;
    }
}
