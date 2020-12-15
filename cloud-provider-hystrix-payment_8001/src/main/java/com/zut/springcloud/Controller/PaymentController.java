package com.zut.springcloud.Controller;

import com.zut.springcloud.Service.PaymentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.Controller
 * @date 2020/11/22 21:21
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    public PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String OK(@PathVariable("id")Integer id){
        log.info("我tm要暴力了");
        return paymentService.HystrixOk(id);
    }
    @GetMapping("/payment/hystrix/err/{id}")
    public String Err(@PathVariable("id")Integer id){
        return paymentService.HystrixErr(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentServiceBreaker(@PathVariable("id")Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("result ===== "+ s);
        return s;
    }
}
