package me.devjian.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)) {
			
			System.out.println(ctx.getBean(BusinessCalculationDataService.class).findMax());
			
		}
	}
}
