package com.sunhui.springcloud.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类：
 */


@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }

}
