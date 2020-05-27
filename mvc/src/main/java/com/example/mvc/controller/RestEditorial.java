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

import com.example.mvc.model.Editorial;
import com.example.mvc.services.interfaces.Servicio;

@RestController
@RequestMapping("editorial")
public class RestEditorial {
	
	@Autowired
	@Qualifier("ServEditorial")
	private Servicio<Editorial,Integer> servicio;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Editorial> all(){
		return servicio.getElements();
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Editorial get(@PathVariable int id){
		return servicio.getElement(id);
	}
	
	@PostMapping(value = "/nueva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void nueva(@Validated @RequestBody Editorial editorial){
		servicio.save(editorial);
	}
	@PutMapping(value = "/{id}/{nuevoNombre}")
	public void nueva(@PathVariable int id,@PathVariable("nuevoNombre") String nombre){
		Editorial editorial = servicio.getElement(id);
		editorial.setNombre(nombre);
		servicio.save(editorial);
	}
	
	@DeleteMapping(value = "/del/{id}")
	public void delete(@PathVariable int id){
		servicio.delete(id);
	}

}
