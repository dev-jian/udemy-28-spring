package me.devjian.springboot.myfirstwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import me.devjian.springboot.myfirstwebapp.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping("login")
    public String loginPage(ModelMap model) {
	
        return "login";
    }
	
	@PostMapping("login")
	public String getWelcomePage(@Valid TestRequest request, ModelMap model) {
		
		logger.debug(request.toString());
		
		if (authenticationService.authenticate(request.getName(), request.getPassword())) {
			
			model.put("name", request.getName());
			
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials.");
		
		return "login";
	}
}
