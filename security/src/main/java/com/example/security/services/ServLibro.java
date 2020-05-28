package com.example.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.dao.LibroRepository;
import com.example.security.model.Libro;
import com.example.security.services.interfaces.Servicio;

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
