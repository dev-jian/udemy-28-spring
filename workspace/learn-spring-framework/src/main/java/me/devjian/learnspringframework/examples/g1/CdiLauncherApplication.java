package me.devjian.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class BusinessService {
	private DataService dataService;

	
	public DataService getDataService() {
		return dataService;
	}
		
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("setter called");
		this.dataService = dataService;
	}
	
}

@Component
class DataService {
	
}

@Configuration
@ComponentScan
public class CdiLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var ctx = 
				new AnnotationConfigApplicationContext(CdiLauncherApplication.class)) {
			
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(ctx.getBean(BusinessService.class).toString());
		}
	}
}
