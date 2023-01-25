package me.devjian.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {};

record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Wanzi";
	}
	
	@Bean
	public int age() {
		return 29;
	}
	
	@Bean
	public Person person() {
		
		return new Person("Wanzi", 31, new Address("Seoul", "Korea"));
	}
	
	@Bean(name = "address2")
	public Address address() {
		
		return new Address("Baker Street", "London");
	}
	
	@Bean
	public Person person2MethodCall() {
		
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
		
		return new Person(name, age, address2);
	}
}
