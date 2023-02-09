package me.devjian.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Clean Up!");
	}
}

@Component
class SomeDependency {
	
	public void getReady() {
		System.out.println("Some logic using dependencies");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)) {
			
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
