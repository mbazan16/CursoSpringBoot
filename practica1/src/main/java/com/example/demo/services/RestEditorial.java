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
import com.example.demo.model.Editorial;

@RestController
@RequestMapping("editorial")
public class RestEditorial {
	
	final static Logger logger = LoggerFactory.getLogger(RestEditorial.class);
	
	@Autowired
	@Qualifier("ServEditoriales")
	private Servicio<Editorial,Long> servicio;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Editorial> all(){
		logger.info("[RestEditorial-all]");
		
		List<Editorial> editoriales = servicio.getElements();
		logger.info("editoriales:"+editoriales);
		return editoriales;
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Editorial get(@PathVariable long id){
		logger.info("[RestEditorial-get] id:"+id);
		
		return servicio.getElement(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void nueva(@Validated @RequestBody Editorial editorial){
		logger.info("[RestEditorial-nueva] editorial:"+editorial);
		
		servicio.save(editorial);
	}
	@PutMapping(value = "/{id}/{nuevoNombre}")
	public void modificar(@PathVariable long id,@PathVariable("nuevoNombre") String nombre){
		logger.info("[RestEditorial-modificar] id:"+id+" nombre:"+ nombre);
		
		Editorial editorial = servicio.getElement(id);
		editorial.setNombre(nombre);
		servicio.save(editorial);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id){
		logger.info("[RestEditorial-delete] id:"+id);
		
		servicio.delete(id);
	}

}
