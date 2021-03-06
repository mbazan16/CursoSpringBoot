package com.example.session.configuration;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	public static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

    @Override

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
    	logger.info("[CustomAuthenticationFailureHandler- onAuthenticationFailure");
		
    	logger.info("username: "+request.getParameter("username"));
    	logger.info("password: "+request.getParameter("password"));
    	//logger.error("Exception:",e);
    	response.sendRedirect("/error");
    }

}