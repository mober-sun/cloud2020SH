package com.sunhui.springcloud.service.impl;

import com.sunhui.springcloud.dao.PaymentMapper;
import com.sunhui.springcloud.entities.Payment;
import com.sunhui.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description;
 * @Author:sunhui
 * @Date:2020/3/22 20:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
