package com.sunhui.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载平衡算法
 */
public interface LoadBalancer {
    // 在多个服务实例中进行选择进行调用
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
