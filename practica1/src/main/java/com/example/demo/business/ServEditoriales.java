package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.Servicio;
import com.example.demo.model.Editorial;
import com.example.demo.respository.EditorialesRepository;

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
		
		return repositorio.findOne(id);
	}

	@Override
	public void save(Editorial element) {
		repositorio.save(element);
		
	}

	@Override
	public void delete(Long id) {
		repositorio.delete(id);
	}

}
