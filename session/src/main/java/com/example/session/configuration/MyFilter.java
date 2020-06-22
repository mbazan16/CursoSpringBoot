package com.example.session.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.session.dao.UsuarioRepository;


public class MyFilter  extends HttpFilter{
	
	
	private static final long serialVersionUID = 1L;

	public static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

	

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain)
			throws IOException, ServletException {        
        
		/*
		 * logger.info( "Principal : {}", request.getUserPrincipal());
		 */ 
		
        if(request.authenticate(response)) {
        	 String auth = request.getHeader("Authorization");
        	logger.info("Esta autenticado auth:"+auth);
        	if(auth!=null) {
            String coded_user_password = auth.split(" ") [1];
            String decoded_user_password = StringUtils.newStringUtf8(Base64.decodeBase64(coded_user_password));
       
            String username = decoded_user_password.split(":")[0];
            String password = decoded_user_password.split(":")[1];
            logger.info("username:"+username);
            logger.info("password:"+password);
        	}
        }
        chain.doFilter(request, response);
		
		/*
		 * logger.info( "Principal : {}", request.getUserPrincipal());
		 */
	}

}
