package com.zut.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 王朝的宇宙
 * @version V1.0
 * @Package com.zut.springcloud
 * @date 2020/11/22 21:09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }

     @Bean
     public ServletRegistrationBean getServlet(){
         HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
         ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(streamServlet);
         servletRegistrationBean.setLoadOnStartup(1);
         servletRegistrationBean.addUrlMappings("/hystrix.stream");
         servletRegistrationBean.setName("HystrixMetricsStreamServlet");
         return  servletRegistrationBean;
     }
}
