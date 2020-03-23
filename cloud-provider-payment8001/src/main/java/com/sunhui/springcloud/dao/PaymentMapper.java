package com.sunhui.springcloud.dao;

import com.sunhui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description;
 * @Author:sunhui
 * @Date:2020/3/22 20:36
 */

@Mapper
public interface PaymentMapper {

    int create (Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
