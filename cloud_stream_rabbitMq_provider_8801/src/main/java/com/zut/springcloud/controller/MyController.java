package com.zut.springcloud.controller;

import com.zut.springcloud.service.MyMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.controller
 * @date 2020/12/18 23:03
 */
@RestController
@RequestMapping("/send")
public class MyController {

    @Resource
    public MyMessage myMessage;

    @GetMapping(value = "/sendMassage")
    public String SendMassage(){
        return myMessage.send();
    }

}
