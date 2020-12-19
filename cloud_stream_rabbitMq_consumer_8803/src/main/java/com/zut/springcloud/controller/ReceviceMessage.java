package com.zut.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.controller
 * @date 2020/12/19 12:56
 */
@Component
@EnableBinding(Sink.class)
public class ReceviceMessage {
    @Value("${server.port}")
    private String ServerPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号 "+message.getPayload()+"端口号为： "+ServerPort);
    }



}
