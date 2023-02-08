package me.devjian.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	@Component
	class ClassA {
		
	}
	
	@Lazy
	@Component
	class ClassB {
		
		private ClassA classA;

		public ClassB(ClassA classA) {
			System.out.println("Some Logic");
			this.classA = classA;
		}
		
		public void doSomething() {
			System.out.println("do something");
		}
	}
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			
			ctx.getBean(ClassB.class).doSomething();
		}
	}
}
