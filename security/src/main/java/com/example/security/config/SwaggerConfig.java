package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		/*
		 * Nos da informacion de todos los controladores del paquete
		 * com.example.security.controller return new
		 * Docket(DocumentationType.SWAGGER_2) .select() .apis(RequestHandlerSelectors
		 * .basePackage("com.example.security.controller")) .paths(PathSelectors.any())
		 * .build();
		 */

		

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/editorial/**")).build();
	}
}
