package com.example.oauth2.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServices {
	@RequestMapping("/publica")
	  public String publico() {
		   return "Pagina Publica";
	  }
	  @RequestMapping("/privada")
	  public String privada() {
	         return "Pagina Privada";
	  }
	  @RequestMapping("/admin")
	  public String admin() {
		    return "Pagina Administrador";
	  }

}
