package com.example.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
	List<Libro> findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
}
