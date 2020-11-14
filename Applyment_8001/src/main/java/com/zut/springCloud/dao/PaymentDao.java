package com.zut.springCloud.dao;

import com.zut.springCloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    //一个写一个读操作
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
