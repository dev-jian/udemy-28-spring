package me.devjian.restfulwebservices.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String helloController() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBeanController() {
        return new HelloWorldBean("Hello World !");
    }
}
