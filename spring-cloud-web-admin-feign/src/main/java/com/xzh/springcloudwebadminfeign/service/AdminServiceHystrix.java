package com.xzh.springcloudwebadminfeign.service;

import org.springframework.stereotype.Component;

/**
 *
 * 创建熔断器类并实现对应的 Feign 接口
 *
 */
@Component
public class AdminServiceHystrix implements AdminService{

    @Override
    public String sayHi(String message) {
        return "你发送的信息是 :" + message + " 但是请求失败了。。该信息为熔断返回的信息";
    }
}
