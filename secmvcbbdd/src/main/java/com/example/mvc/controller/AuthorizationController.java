package com.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {
	
	final static Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	
	

	@GetMapping({"/","/login"})
	public String index(Model model) {
		
		logger.info("[AuthorizationController-login]");
		
		return "index";
	}
	
	
	
	@GetMapping({"/accesDenied"})
	public String accesDenied(Model model) {
		
		logger.info("[AuthorizationController-accesDenied]");

		return "accesDenied";
	}
	
	@GetMapping({"/user"})
	public String user(Authentication authentication) {
		
		logger.info("[AuthorizationController-user]");
		
		logger.info("nombre:"+authentication.getName());
		
		logger.info("authorities:"+authentication.getAuthorities());
		
		logger.info("credenciales:"+authentication.getCredentials());
		
		logger.info("details:"+authentication.getDetails());
		
		logger.info("principal:"+authentication.getPrincipal());
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return "user";
	}
	
	@GetMapping({"/username"})
	public String username(HttpServletRequest request) {
		
		logger.info("[AuthorizationController-username]");
		
		logger.info("nombre:"+request.getUserPrincipal().getName());
		return "user";
	}
	
	
}
