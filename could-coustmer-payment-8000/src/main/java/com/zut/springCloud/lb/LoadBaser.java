package com.zut.springCloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.lb
 * @date 2020/11/17 17:19
 */
public interface LoadBaser {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
