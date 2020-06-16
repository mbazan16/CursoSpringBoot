package com.example.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.example.demo.business.interfaces.Servicio;
import com.example.demo.model.Libro;

@RestController
@RequestMapping("libro")
public class RestLibro {
	
	final static Logger logger = LoggerFactory.getLogger(RestLibro.class);
	
	@Autowired
	@Qualifier("ServLibros")
	private Servicio<Libro,Long> servicio;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> all(){
		logger.info("[RestLibro-all]");
		
		return servicio.getElements();
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro get(@PathVariable long id){
		logger.info("[RestLibro-get] id:"+id);
		
		return servicio.getElement(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void nueva(@Validated @RequestBody Libro libro){
		logger.info("[RestLibro-nueva] libro:"+libro);
		
		servicio.save(libro);
	}
	@PutMapping(value = "/{id}/{nuevoTitulo}")
	public void modificar(@PathVariable long id,@PathVariable("nuevoTitulo") String titulo){
		logger.info("[RestLibro-modificar] id:"+id+" titulo:"+ titulo);
		
		Libro libro = servicio.getElement(id);
		libro.setTitulo(titulo);
		servicio.save(libro);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id){
		logger.info("[RestLibro-delete] id:"+id);
		
		servicio.delete(id);
	}

}
