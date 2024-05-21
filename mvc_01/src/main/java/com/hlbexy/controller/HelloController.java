package com.hlbexy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value = {"/welcome", "/do"}, name = "跳转到欢迎页", method = RequestMethod.GET)
    public String testValue() {
        return "welcome";
    }
    @RequestMapping(value = "/testParam", params = {"name=springmvc", "url=http://c.biancheng.net"})
    public String params() {
        return "param";
    }

    @RequestMapping(value = "/testHeader", headers = {"Content-Type=application/json", "Referer=http://c.biancheng.net"})
    public String headers() {
        return "header";
    }
}
