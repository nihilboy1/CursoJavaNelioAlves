package com.nihil.springintro.resources;

import com.nihil.springintro.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // declara que essa classe é um controlador rest
@RequestMapping(value = "/users")
public class UserResource{

    @GetMapping // declara que essa função responde ao get
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "999999", "123456");
        return ResponseEntity.ok().body(u);
    }
}
