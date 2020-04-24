package com.xzh.springcloudwebadminribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 熔断
     * 在 Ribbon 调用方法上增加 @HystrixCommand 注解并指定 fallbackMethod 熔断方法
     *
     * @param message
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message) {
        return restTemplate.getForObject("http://HELLO-SPRING-CLOUD-SERVICE-ADMIN/say?message=" + message, String.class);
    }

    public String hiError(String message) {
        return "你发送的信息是 :" + message + " 但是请求失败了。。该信息为熔断返回的信息";
    }
}
