package me.devjian.learnspringframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import me.devjian.learnspringframework.game.GameRunner;
import me.devjian.learnspringframework.game.GamingConsole;

@ComponentScan(basePackages = {"me.devjian.learnspringframework.game"})
@Configuration
public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {
			GameRunner gameRunner = (GameRunner) ctx.getBean("gameRunner");
			gameRunner.run();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
