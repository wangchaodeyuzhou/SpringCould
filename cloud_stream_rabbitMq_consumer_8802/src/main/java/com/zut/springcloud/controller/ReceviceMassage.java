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
 * @date 2020/12/19 12:26
 */
@Component
@EnableBinding(Sink.class)
public class ReceviceMassage {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接受者1号接收到的消息为:  "+message.getPayload()+"端口号为: "+ serverPort);
    }


}
