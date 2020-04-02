package com.sunhui.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @EnableDiscoveryClient : 支持其他的注册中心
 *
 * @EnableEurekaClient ： 仅支持eureka 
 * 两者的作用：让注册中心能够发现，扫描到服务
 *
 */
@SpringBootApplication
@EnableDiscoveryClient

public class Payment8006 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8006.class,args);
    }
}
