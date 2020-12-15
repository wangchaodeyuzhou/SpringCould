package com.zut.springcloud.Service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.Service
 * @date 2020/11/25 21:32
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    public String ServerPort;

    public String HystrixOk(Integer id){
        return "线程： "+Thread.currentThread().getName()+"端口： "+ServerPort;
    }

    @HystrixCommand(fallbackMethod="Timeout_Handler",commandProperties={
       @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String HystrixErr(Integer id){
        int time_out = 2;
        try {
            TimeUnit.SECONDS.sleep(time_out);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i = 10/0;
        return "线程： "+Thread.currentThread().getName()+"端口： "+ServerPort;
    }

   public String Timeout_Handler(Integer id){
        return "服务器繁忙，请稍后重式";
   }

   @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
           @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
           @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
           @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口过期时间
           @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率多少时候断开
   })
  public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id<0) throw new RuntimeException("*****id不能为负数");
        String serilaNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() +"\t"+"调用成功：流水号: "+ serilaNumber;
   }

   public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id 不能负数, 请稍后再试 //(T 0 T)/~ id: "+id;
   }

}
