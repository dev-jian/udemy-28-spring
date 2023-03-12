package me.devjian.springboot.myfirstwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
    @GetMapping("say-hello")
    public String test(@Valid TestRequest request) {
    	
    	
        return "Hello ~";
    }
}
