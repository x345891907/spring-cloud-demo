package com.xzh.springcloudwebadminfeign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-spring-cloud-service-admin")
public interface AdminService {
    @RequestMapping(value = "say", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
