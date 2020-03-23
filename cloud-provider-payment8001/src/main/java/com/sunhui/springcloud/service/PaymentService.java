package com.sunhui.springcloud.service;

import com.sunhui.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description;
 * @Author:sunhui
 * @Date:2020/3/22 20:33
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
