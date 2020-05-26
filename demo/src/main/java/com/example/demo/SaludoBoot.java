package com.example.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoBoot {
	
	@GetMapping(value="saludo",produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Mi saludo";
	}

}