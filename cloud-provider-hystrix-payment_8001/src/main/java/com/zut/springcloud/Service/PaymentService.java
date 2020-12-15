package com.zut.springcloud.Service;

import com.sun.jdi.ThreadReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.Service
 * @date 2020/11/22 21:20
 */
@Service
public interface PaymentService {
    public String HystrixOk(Integer id);

    public String HystrixErr(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
