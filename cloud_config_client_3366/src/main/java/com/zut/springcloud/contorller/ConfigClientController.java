package com.zut.springcloud.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud.contorller
 * @date 2020/12/17 21:52
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping("/ConfigInfo")
    public String getConfigInfo(){
        return ConfigInfo;
    }

}
