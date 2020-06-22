package com.example.session.bussines;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.session.dto.UsuarioSession;
import com.example.session.services.RestSession;

@Service
public class ServSession {
	
	final static Logger logger = LoggerFactory.getLogger(RestSession.class);
	
	@Autowired
	UsuarioSession usuarioSession;
	
	public void init(HttpServletRequest request) {
		logger.info("[ServSession-init ]"); 
		logger.info("SessionId:"+request.getSession().getId());
		String username=request.getUserPrincipal().getName();
		if(usuarioSession.getUsername()==null || usuarioSession.getUsername()!=username) {
			usuarioSession.setUsername(username);
			logger.info("Recogemos username:"+usuarioSession.getUsername());
		}
		logger.info("UsuarioSession:"+usuarioSession);
		
	}

}
