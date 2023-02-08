package me.devjian.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	@Component
	class YourBusinessClass {
		
		Dependency1 dependency1;
		
		Dependency2 dependency2;
		
		public Dependency1 getDependency1() {
			return dependency1;
		}

		@Autowired
		public void setDependency1(Dependency1 dependency1) {
			this.dependency1 = dependency1;
		}


		public Dependency2 getDependency2() {
			return dependency2;
		}

		@Autowired
		public void setDependency2(Dependency2 dependency2) {
			this.dependency2 = dependency2;
		}

		public String toString() {
			return "Using " + dependency1 + " and " + dependency2;
		}
	} 
	
	@Component
	class Dependency1 {
		
	}
	
	@Component
	class Dependency2 {
		
	}
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(ctx.getBean(YourBusinessClass.class).toString());
		}
	}
}
