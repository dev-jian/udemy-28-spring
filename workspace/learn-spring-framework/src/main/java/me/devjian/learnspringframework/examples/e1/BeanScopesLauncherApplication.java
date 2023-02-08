package me.devjian.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
			
			System.out.println(ctx.getBean(NormalClass.class));
			System.out.println(ctx.getBean(NormalClass.class));

			System.out.println(ctx.getBean(PrototypeClass.class));
			System.out.println(ctx.getBean(PrototypeClass.class));
		}
	}
}
