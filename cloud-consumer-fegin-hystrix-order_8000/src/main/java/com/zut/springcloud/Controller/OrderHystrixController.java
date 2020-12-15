package com.zut.springcloud.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zut.springcloud.Service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.Controller
 * @date 2020/11/25 21:16
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "GglobalServiceFallback")
public class OrderHystrixController {
    @Resource
    public PaymentService paymentService;

    @GetMapping("/order/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentService.HystrixOk(id);
    }

    @GetMapping("/order/payment/hystrix/err/{id}")
    public String Err(@PathVariable("id") Integer id) {
        return paymentService.HystrixErr(id);
    }

    @GetMapping("/consumer/payment/hystix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "PaymentTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3100")
    })
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String hystrixErr = paymentService.HystrixErr(id);
        return hystrixErr;
    }

    public String PaymentTimeoutFallbackMethod(Integer id) {
        return "我tm就是一个服务降级的" + "， 说的好听听点就是一个擦汗屁股的";
    }


    @HystrixCommand
    @GetMapping("/consumer/payment/hystix/ArrV/{id}")
    public String ArrV(@PathVariable("id")Integer id){
        int i =10/0;
        return "我是你爸爸";
    }

    // 定义全局的服务降级


    public String GglobalServiceFallback(){
         return "我是全局的服务降级";
    }
}
