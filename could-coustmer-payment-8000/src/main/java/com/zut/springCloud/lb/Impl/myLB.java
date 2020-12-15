package com.zut.springCloud.lb.Impl;

import com.zut.springCloud.lb.LoadBaser;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.lb.Impl
 * @date 2020/11/17 17:23
 */
@Component
public class myLB implements LoadBaser {

    private AtomicInteger atomicInteger =new AtomicInteger(0);
    private final int getAndIncrement(){
        int current;
        int next;
        do{
          current = this.atomicInteger.get();
          //出现了越界考虑一下
          next = current >= 2147483647 ? 0 : current +1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("_________第几次访问的next值: " + next);
        return next;
    }


    // 轮询算法的实现过程
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
