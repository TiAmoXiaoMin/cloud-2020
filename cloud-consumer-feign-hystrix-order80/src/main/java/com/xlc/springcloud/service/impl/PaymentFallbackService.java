package com.xlc.springcloud.service.impl;

import com.xlc.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {

        return "PaymentFallbackService fall back : paymentInfo_OK O T O";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {

        return "PaymentFallbackService fall back : paymentInfo_TimeOut O T O";
    }
}
