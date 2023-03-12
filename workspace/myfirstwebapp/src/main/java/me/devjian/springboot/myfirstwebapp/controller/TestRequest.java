package me.devjian.springboot.myfirstwebapp.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import me.devjian.springboot.myfirstwebapp.enums.GENDER;

public class TestRequest {
	
	@NotBlank
	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TestRequest [name=" + name + ", password=" + password + "]";
	}
}
