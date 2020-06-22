package com.example.session.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UsuarioSession {
	
	private String username;
	
	@Value("ES")
	private String language;

	public UsuarioSession() {
		super();
	}



	public UsuarioSession(String username) {
		super();
		this.username = username;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	@Override
	public String toString() {
		return "UsuarioSession [username=" + username + ", language=" + language + "]";
	}



	
	

}
