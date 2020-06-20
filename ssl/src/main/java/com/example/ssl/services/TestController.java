package com.example.ssl.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class TestController {
 
    @RequestMapping
    public String doAlive() {
        return "Alive!";
    }
 
   
}