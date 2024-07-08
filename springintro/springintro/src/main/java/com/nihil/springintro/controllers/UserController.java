package com.nihil.springintro.controllers;

import com.nihil.springintro.entities.User;
import com.nihil.springintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // declara que essa classe é um COMPONENTE CONTROLLER rest
@RequestMapping(value = "/users")
public class UserController{
    @Autowired
    private UserService service;

    @GetMapping // declara que esse método responde ao get em /users
    public ResponseEntity<List<User>> findAll(){
        // na camada atual de controller, eu chamo a camada de serviços, que por sua vez, chama o repository que
        // retorna a lista de usuários
        List<User> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
