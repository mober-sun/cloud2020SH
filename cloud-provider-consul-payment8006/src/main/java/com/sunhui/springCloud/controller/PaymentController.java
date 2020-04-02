package com.sunhui.springCloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 关于consul 做注册中心，和zookeeper差不多，先把注册中心搭建起来，然后把服务注册到上面去就好了。
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springCloudConsul  ,   port:  "+port+ "    "+UUID.randomUUID().toString();
    }

}
