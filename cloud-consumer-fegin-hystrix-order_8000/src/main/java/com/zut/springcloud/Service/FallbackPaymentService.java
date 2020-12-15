package com.zut.springcloud.Service;

import org.springframework.stereotype.Component;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.Service
 * @date 2020/12/7 21:15
 */
@Component
public class FallbackPaymentService implements PaymentService{

    @Override
    public String HystrixOk(Integer id) {
        return "我去你妈的我的8001服务器已经宕机了";
    }

    @Override
    public String HystrixErr(Integer id) {
        return "发声明了什莫事";
    }
}
