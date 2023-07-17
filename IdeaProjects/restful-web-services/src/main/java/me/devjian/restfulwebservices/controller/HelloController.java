package me.devjian.restfulwebservices.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Data
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloController() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBeanController() {
        return new HelloWorldBean("Hello World !");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World %s!", name));
    }

    @GetMapping("/hello-world-i18n")
    public String helloControllerI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, null, locale);
    }
}
