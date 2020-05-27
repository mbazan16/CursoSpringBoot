package com.example.mvc.controller;

import java.util.List;

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

import com.example.mvc.model.Libro;
import com.example.mvc.services.interfaces.Servicio;

@RestController
@RequestMapping("libro")
public class RestLibro {
	
	@Autowired
	@Qualifier("ServLibro")
	private Servicio<Libro,Integer> servicio;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> all(){
		return servicio.getElements();
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro get(@PathVariable int id){
		return servicio.getElement(id);
	}
	
	@PostMapping(value = "/nueva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void nueva(@Validated @RequestBody Libro libro){
		servicio.save(libro);
	}
	@PutMapping(value = "/{id}/{nuevoAutor}")
	public void nueva(@PathVariable int id,@PathVariable("nuevoAutor") String autor){
		Libro libro = servicio.getElement(id);
		libro.setAutor(autor);
		servicio.save(libro);
	}
	
	@DeleteMapping(value = "/del/{id}")
	public void delete(@PathVariable int id){
		servicio.delete(id);
	}

}
