package com.xlc.springcloud.servie.impl;

import com.xlc.springcloud.dao.PaymentDao;
import com.xlc.springcloud.entities.Payment;
import com.xlc.springcloud.servie.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment findByPaymentId(Long id) {
        return paymentDao.selectByPaymentId(id);
    }
}
