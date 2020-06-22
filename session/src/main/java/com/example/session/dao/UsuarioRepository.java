package com.example.session.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.session.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	Usuario findByNombre(String nombre);

}
