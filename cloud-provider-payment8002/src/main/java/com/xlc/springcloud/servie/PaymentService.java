package com.xlc.springcloud.servie;

import com.xlc.springcloud.entities.Payment;


public interface PaymentService {

    public int savePayment(Payment payment);

    public Payment findByPaymentId(Long id);

}
