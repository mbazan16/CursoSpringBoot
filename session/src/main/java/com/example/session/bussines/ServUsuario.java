package com.example.session.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.session.business.interfaces.Servicio;
import com.example.session.dao.UsuarioRepository;
import com.example.session.dto.UsuarioSession;
import com.example.session.model.Usuario;

@Service("ServUsuario")
public class ServUsuario implements Servicio<Usuario,String>{
	
	@Autowired
	UsuarioRepository repositorio;
	
	@Autowired
	UsuarioSession usuarioSession;

	@Override
	public List<Usuario> getElements() {
		return repositorio.findAll();
	}

	@Override
	public Usuario getElement(String username) {
		
		return repositorio.findById(username).get();
	}

	@Override
	public void save(Usuario element) {
		repositorio.save(element);
		
	}

	@Override
	public void delete(String username) {
		repositorio.deleteById(username);
		
	}

}
