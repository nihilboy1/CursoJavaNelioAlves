package com.nihil.springintro.controllers;

import com.nihil.springintro.entities.Category;
import com.nihil.springintro.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // declara que essa classe é um COMPONENTE CONTROLLER rest
@RequestMapping(value = "/categories")
public class CategoryController{
    @Autowired
    private CategoryService categoryService;

    @GetMapping // declara que esse método responde ao get em /order
    public ResponseEntity<List<Category>> findAll(){
        // na camada atual de controller, eu chamo a camada de serviços, que por sua vez, chama o repository que
        // retorna a lista de pedidos
        List<Category> categoryList = categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category user = categoryService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
