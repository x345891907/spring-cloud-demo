package com.xzh.springcloudserviceadmin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "say", method = RequestMethod.GET)
    public String sayHi(@RequestParam("message") String message) {

        return String.format("你发的信息是 : %s 端口是 : %s", message, port);
    }

}
