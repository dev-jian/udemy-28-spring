package me.devjian.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.devjian.learnspringframework.game.GameRunner;
import me.devjian.learnspringframework.game.MarioGame;
import me.devjian.learnspringframework.game.PacmanGame;
import me.devjian.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		try (// 1: Launch a Spring Context
			var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
				// 2: Configure the things that we want Spring to manage - @Configuration
				System.out.println(ctx.getBean("name"));
				
				System.out.println(ctx.getBean("person"));
				
				System.out.println(ctx.getBean("address2"));
				
				System.out.println(ctx.getBean(Address.class));
				
				System.out.println(ctx.getBean("person2MethodCall"));
				
				System.out.println(ctx.getBean("person3Parameters"));
				
				Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
