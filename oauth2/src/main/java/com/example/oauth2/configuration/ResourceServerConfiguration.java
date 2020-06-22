package com.example.oauth2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer

@Configuration

public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {



  @Override

  public void configure(ResourceServerSecurityConfigurer resources)throws Exception{

    resources.resourceId("client_api");

  }


  @Override
  public void configure(HttpSecurity http) throws Exception {
  	http
  	.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll();  
//  	 .anyRequest().authenticated(); 

  	http.requestMatchers().antMatchers("/publica")  //Acceso publico
  	.and().authorizeRequests()
  	.antMatchers("/privada").access("hasRole('USER')") 
  	.antMatchers("/admin").access("hasRole('ADMIN')");
  }
}