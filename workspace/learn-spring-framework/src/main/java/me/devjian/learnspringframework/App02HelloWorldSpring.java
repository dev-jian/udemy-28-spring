package me.devjian.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.devjian.learnspringframework.game.GameRunner;
import me.devjian.learnspringframework.game.MarioGame;
import me.devjian.learnspringframework.game.PacmanGame;
import me.devjian.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		// 1: Launch a Spring Context
		var ctx = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// 2: Configure the things that we want Spring to manage - @Configuration
		System.out.println(ctx.getBean("name"));
	}

}
