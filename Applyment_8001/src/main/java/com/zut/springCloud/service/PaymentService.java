package com.zut.springCloud.service;

import com.zut.springCloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //一个写一个读操作
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
