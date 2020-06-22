package com.example.session.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    @Bean
    public UserInterceptor pagePopulationInterceptor() {
        return new UserInterceptor();
    }


    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
       // registry.addInterceptor(new UserInterceptor());
    }
}