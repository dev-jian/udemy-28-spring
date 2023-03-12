package me.devjian.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = "devjian".equalsIgnoreCase(username);
		boolean isValidPassword = "12cm1364".equalsIgnoreCase(password);
		
		return isValidUserName && isValidPassword;
	}
}
