package me.devjian.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Configuration
@ComponentScan
public class CdiLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
		
				Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
