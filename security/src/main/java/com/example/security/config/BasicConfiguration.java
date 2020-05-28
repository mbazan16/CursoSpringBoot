package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
	  
	/*
	 * Configuracción Base
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder(); auth
	 * .inMemoryAuthentication() .withUser("user")
	 * .password(encoder.encode("password")) .roles("USER") .and()
	 * .withUser("admin") .password(encoder.encode("admin")) .roles("USER",
	 * "ADMIN"); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic(); }
	 */
    
    @Bean
	public AuthenticationManager authMg() throws Exception {
		return super.authenticationManagerBean();
	}
	//definición roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("COMUN")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("COMUN", "PROF");
		
		/*lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		 * auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password(new BCryptPasswordEncoder().encode("user1"))
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password(new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		
		/*la siguiente configuración sería para el caso de 
		 * usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled"
            	+ " from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority "
            	+ "from authorities where username=?");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/editorial/**").hasRole("PROF")	
		.antMatchers(HttpMethod.DELETE,"/libro/**").hasRole("PROF")	
		.antMatchers(HttpMethod.PUT,"/libro/**").hasRole("PROF")
		.antMatchers(HttpMethod.POST,"/libro/**").hasRole("PROF")
		.antMatchers("/libro/**").hasRole("COMUN")	
		.and()
		.httpBasic();
	
	}
}

