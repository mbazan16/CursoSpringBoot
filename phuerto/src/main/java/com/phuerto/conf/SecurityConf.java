package com.phuerto.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

	
	
	@Bean
	public AuthenticationManager authMg() throws Exception {
		return super.authenticationManagerBean();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("cliente")
		.password("{noop}cliente")
		.roles("CLIENT")
		.and()
		.withUser("admin")
		.password("{noop}admin")
		.roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		//.antMatchers("/h2-console/**").permitAll()
		//.antMatchers("contains:grabar").hasRole("ADMIN")
		//.anyRequest().authenticated()
		.and()
		.headers().frameOptions().disable()
		.and()
		.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
		.httpBasic();

	}

}
