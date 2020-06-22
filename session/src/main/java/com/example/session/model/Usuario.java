package com.example.session.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;

@Entity
@XmlRootElement
public class Usuario {
	
	@Id
	private String username;
	
	private String nombre;
	private String telefono;
	private String email;

	public Usuario() {
		super();
	}

	public Usuario(String username, String nombre, String telefono, String email) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
