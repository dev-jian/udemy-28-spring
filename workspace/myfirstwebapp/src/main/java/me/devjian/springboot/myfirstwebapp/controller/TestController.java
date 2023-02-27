package me.devjian.springboot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("say-hello")
    @ResponseBody
    public String test() {
        return "Hello ~";
    }

    @GetMapping("say-hello-jsp")
    public String getView() {
        return "sayHello";
    }
}
