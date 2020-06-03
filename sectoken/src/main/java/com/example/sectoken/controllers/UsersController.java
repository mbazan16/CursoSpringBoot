package com.example.sectoken.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sectoken.model.Usuario;

@RestController
public class UsersController {

    @GetMapping(path = "/users")
    public List<Usuario> getUsers(){
        return Arrays.asList(new Usuario(1,"Paco"), new Usuario(2,"Pedro"), new Usuario(3, "Juan"));
    }
}