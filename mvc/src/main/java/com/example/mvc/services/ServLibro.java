package com.example.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mvc.dao.LibroRepository;
import com.example.mvc.model.Libro;
import com.example.mvc.services.interfaces.Servicio;

@Service("ServLibro")
public class ServLibro implements Servicio<Libro,Integer>{
	
	@Autowired
	LibroRepository repositorio;
	
	

	@Override
	public List<Libro> getElements() {
		return repositorio.findAll();
	}

	@Override
	public Libro getElement(Integer id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public void save(Libro element) {
		repositorio.save(element);
		
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);
		
	}

}
