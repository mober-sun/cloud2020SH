package com.sunhui.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 自定义 负载均衡
 */
@Component
public class Mylb implements LoadBalancer {

    // 原子Integer 初始值是0； 后续每次请求+1，服务重启清零 从新开始
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问，次数next:"+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 真正的算法 依次取余
        int i = getAndIncrement()%serviceInstances.size();

        return serviceInstances.get(i);
    }
}
