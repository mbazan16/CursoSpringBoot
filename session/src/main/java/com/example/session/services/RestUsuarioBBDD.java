package com.example.session.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.session.business.interfaces.Servicio;
import com.example.session.bussines.ServSession;
import com.example.session.model.Usuario;

@RestController
@RequestMapping("usuarios")
public class RestUsuarioBBDD {
	
final static Logger logger = LoggerFactory.getLogger(RestUsuarioBBDD.class);
	
	@Autowired
	Servicio<Usuario,String> servicio;
	@Autowired
	ServSession servSession;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findAll(HttpServletRequest request){
	      logger.info("RestUsuario[findAll]");
	      servSession.init(request);
		return servicio.getElements();
	}
	@GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findOne(@PathVariable String username,HttpServletRequest request){
	      logger.info("RestUsuario[findOne]");
	      logger.info("username"+username);
	      servSession.init(request);
		return servicio.getElement(username);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@Validated @RequestBody Usuario usuario,HttpServletRequest request){
	      logger.info("RestUsuario[save])");
	      logger.info("usuario"+usuario);
	      servSession.init(request);
	      
		servicio.save(usuario);
	}
	@PutMapping(value = "/{username}/{autor}")
	public void save(@PathVariable String username,@PathVariable String nombre,HttpServletRequest request){
	      logger.info("RestUsuario[save]");
	      logger.info("username"+username);
	      logger.info("nombre"+nombre);
	      servSession.init(request);
		Usuario usuario = servicio.getElement(username);
		usuario.setNombre(nombre);
		servicio.save(usuario);
	}
	
	@DeleteMapping(value = "/{username}")
	public void delete(@PathVariable String username,HttpServletRequest request){
	      logger.info("RestUsuario[delete]");
	      logger.info("username"+username);
	      servSession.init(request);
		servicio.delete(username);
	}

}
