package com.sunhui.springcloud.controller;

import com.sunhui.springcloud.entities.CommonResult;
import com.sunhui.springcloud.entities.Payment;
import com.sunhui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @description;
 * @Author:sunhui
 * @Date:2020/3/22 20:27
 *
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入数据ID:\t"+payment.getId());
        log.info("插入结果：\t"+i);


        if(i>0){
            return new CommonResult(200,"add success",i);
        }else{
            return new CommonResult(414,"add fail",null);
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果：\t"+paymentById);
        if(paymentById!=null){
            return new CommonResult(200,"get Success——port:"+port+"// uuid:"+ UUID.randomUUID(),paymentById);
        }else
            return new CommonResult(414,"get fail",null);
    }


    @GetMapping("/lb")
    public String getLb(){
        return port;
    }

}
