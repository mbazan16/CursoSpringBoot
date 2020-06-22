package com.example.session.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.session.bussines.ServSession;
import com.example.session.dao.UsuarioRepository;
import com.example.session.dto.UsuarioSession;
import com.example.session.model.Usuario;

@RestController
@RequestMapping("session")
public class RestSession {
	
final static Logger logger = LoggerFactory.getLogger(RestSession.class);
	
    @Autowired
    UsuarioSession usuarioSession;
	@Autowired
	ServSession servSession;
    
    @Autowired
    UsuarioRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findOne(HttpServletRequest request){
	      logger.info("RestSession[findOne]");
	      servSession.init(request);
	      logger.info("usuarioSession:"+usuarioSession);
	      Usuario usuario = repository.findById(usuarioSession.getUsername()).get();
		return usuario;
	}
	
	@GetMapping(value = "/language")
	public String verLanguage(HttpServletRequest request){
	      logger.info("RestSession[language]");
	      servSession.init(request);
	      
		return usuarioSession.getLanguage();
		
	}
	
	@GetMapping(value = "/telefono")
	public String verTelefono(HttpServletRequest request, HttpSession session){
	      logger.info("RestSession[language]");
	      servSession.init(request);
	      String telefono = (String) session.getAttribute("telefono");
	      if(telefono==null) {
	    	  logger.info("Buscamos usuario bbdd");
	    	  Usuario usuario = repository.findById(usuarioSession.getUsername()).get();
	    	  session.setAttribute("telefono", usuario.getTelefono());
	      }
		return (String)session.getAttribute("telefono");
		
	}
	
	@PutMapping(value = "/language/{language}")
	public void save(@PathVariable String language,HttpServletRequest request){
	      logger.info("RestSession[save]");
	      logger.info("language"+language);
	      servSession.init(request);	      
		  usuarioSession.setLanguage(language);
		
	}
	
	
	
	@GetMapping(value = "/sessionExpired")
	public String sessionExpired(){
	      logger.info("RestSession[sessionExpired]");
		
		return "La sessión ha expirado";
	}
	
	@GetMapping(value = "/invalidSession")
	public String invalidSession(){
	      logger.info("RestSession[invalidSession]");
		
		return "La sessión es invalida";
	}
	
	
	

}
