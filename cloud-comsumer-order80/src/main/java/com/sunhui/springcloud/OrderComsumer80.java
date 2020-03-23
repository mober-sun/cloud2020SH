package com.sunhui.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderComsumer80 {
    
    public static void main(String[] args){
        SpringApplication.run(OrderComsumer80.class,args);
    }
}
