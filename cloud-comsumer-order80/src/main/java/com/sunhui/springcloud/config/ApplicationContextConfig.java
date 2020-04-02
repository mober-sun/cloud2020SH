package com.sunhui.springcloud.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类： @loadBalanced 不能放在@componetScan的注解扫描下，这个注解已经集成在@springBootApplication
 */


@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // 负载均衡的去加载
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }



}
