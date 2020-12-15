package com.zut.springcloud.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.Service
 * @date 2020/11/22 21:20
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = FallbackPaymentService.class)
public interface PaymentService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String HystrixOk(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/err/{id}")
    public String HystrixErr(@PathVariable("id") Integer id);
}
