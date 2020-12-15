package com.zut.springCloud.Controller;

import com.zut.springCloud.Service.PaymentFeignService;
import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.Controller
 * @date 2020/11/17 18:58
 */
@RestController
@Slf4j
public class OrderFeignController {

    //调用feign对外的服务接口
    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
      return paymentFeignService.select(id);
    }
    @GetMapping("/customer/payment/feign/timeout")
    public String PaymentFeignTimeout(){
        return paymentFeignService.PaymentFeignTimeout();
    }

 }
