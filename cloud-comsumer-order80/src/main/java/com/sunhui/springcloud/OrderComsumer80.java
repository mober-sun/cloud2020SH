package com.sunhui.springcloud;


import com.sunhui.myrule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = Myrule.class)
public class OrderComsumer80 {
    
    public static void main(String[] args){
        SpringApplication.run(OrderComsumer80.class,args);
    }
}
