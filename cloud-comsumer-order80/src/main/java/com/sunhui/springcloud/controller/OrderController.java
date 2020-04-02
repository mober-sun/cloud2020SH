package com.sunhui.springcloud.controller;


import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sunhui.springcloud.entities.CommonResult;
import com.sunhui.springcloud.entities.Payment;
import com.sunhui.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL ="http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    // 自定义的负载均衡；
    @Autowired
    private LoadBalancer loadBalancer;

    // 直接使用restTemplate 调用 类似于 httpClient
    @GetMapping("/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class,id);
    }


    @GetMapping("/comsumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @RequestMapping("/comsumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();
        String result = restTemplate.getForObject(uri + "/payment/lb", String.class);
        return result;
    }

}
