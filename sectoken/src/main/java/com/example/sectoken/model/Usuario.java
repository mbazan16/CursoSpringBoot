package com.example.sectoken.model;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

public class Usuario {
    private int id;
    private String name;

    public Usuario(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }
	

}
