package com.zut.springcloud.service.impl;

import com.netflix.discovery.converters.Auto;
import com.zut.springcloud.service.MyMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.service.impl
 * @date 2020/12/18 22:57
 */
@EnableBinding(Source.class)
public class MyIMessageImpl implements MyMessage {
    @Autowired
    private MessageChannel output;
    // 定义得是消息的通道实现
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        System.out.println(output.send(MessageBuilder.withPayload(s).build()));
        System.out.println("dslkvslkfvls ======="+ s);
        return null;
    }
}
