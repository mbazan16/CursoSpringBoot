package com.example.rest.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.rest.model.Editorial;
import com.example.rest.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long>{

	
}
	
	
