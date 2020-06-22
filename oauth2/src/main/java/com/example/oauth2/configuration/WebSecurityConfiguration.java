package com.example.oauth2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManager();
	}


	
	
	    @Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	    	
	    	UserDetails user=User.builder().username("user").password(passwordEncoder.encode("secret")).
	    			roles("USER").build();
	    	UserDetails userAdmin=User.builder().username("admin").password(passwordEncoder.encode("secret")).
	    			roles("ADMIN").build();
	        return new InMemoryUserDetailsManager(user,userAdmin);
	    }
	
	   
	}
