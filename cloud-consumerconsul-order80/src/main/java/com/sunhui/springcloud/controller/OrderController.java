package com.sunhui.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/comsumer")
public class OrderController {

//    private static final String SERVER_URL = "http://localhost:8006";

    private static final String SERVER_URL = "http://cloud-provider-consul";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("payment/consul")
    public String order80(){
        String forObject = restTemplate.getForObject(SERVER_URL + "/payment/consul", String.class);
        return forObject;
    }
}
