package com.zut.springCloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springCloud.config
 * @date 2020/11/17 20:02
 */
@Configuration
public class FeignConfig {

   @Bean
    Logger.Level feignLoggerLevel(){
       return Logger.Level.FULL;
   }
}
