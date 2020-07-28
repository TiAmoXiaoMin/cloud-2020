package com.xlc.springcloud.dao;


import com.xlc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int insertPayment(Payment payment);

    public Payment selectByPaymentId(@Param("id") Long id);
}
