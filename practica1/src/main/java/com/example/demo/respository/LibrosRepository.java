package com.example.demo.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Editorial;
import com.example.demo.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long>{

	
}
	
	
