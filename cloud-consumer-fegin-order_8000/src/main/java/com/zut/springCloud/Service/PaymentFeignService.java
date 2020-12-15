package com.zut.springCloud.Service;

import com.zut.springCloud.entity.CommonResult;
import com.zut.springCloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.Service
 * @date 2020/11/17 18:52
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult select(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeout();
}
