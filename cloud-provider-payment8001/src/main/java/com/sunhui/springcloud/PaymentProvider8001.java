package com.sunhui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description;
 * @Author:sunhui
 * @Date:2020/3/22 20:24
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentProvider8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider8001.class,args);
    }
}
