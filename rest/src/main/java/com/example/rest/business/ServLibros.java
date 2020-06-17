package com.example.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.business.interfaces.Servicio;
import com.example.rest.model.Libro;
import com.example.rest.respository.LibrosRepository;

@Service("ServLibros")
public class ServLibros implements Servicio<Libro, Long> {
	
	@Autowired
	LibrosRepository repositorio;

	@Override
	public List<Libro> getElements() {
		
		return repositorio.findAll();
	}

	@Override
	public Libro getElement(Long id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public void save(Libro element) {
		repositorio.save(element);
		
	}

	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
	}

}
