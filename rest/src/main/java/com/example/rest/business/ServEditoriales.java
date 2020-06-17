package com.example.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.business.interfaces.Servicio;
import com.example.rest.model.Editorial;
import com.example.rest.respository.EditorialesRepository;

@Service("ServEditoriales")
public class ServEditoriales implements Servicio<Editorial, Long> {
	
	@Autowired
	EditorialesRepository repositorio;

	@Override
	public List<Editorial> getElements() {
		
		return repositorio.findAll();
	}

	@Override
	public Editorial getElement(Long id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public void save(Editorial element) {
		repositorio.save(element);
		
	}

	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
	}

}
