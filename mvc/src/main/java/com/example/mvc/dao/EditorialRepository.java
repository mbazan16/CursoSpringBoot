package com.example.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.model.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	Editorial findByNombre(String nombre);

}
