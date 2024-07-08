package com.nihil.springintro.controllers;

import com.nihil.springintro.entities.Product;
import com.nihil.springintro.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // declara que essa classe é um COMPONENTE CONTROLLER rest
@RequestMapping(value = "/products")
public class ProductController{
    @Autowired
    private ProductService productService;

    @GetMapping // declara que esse método responde ao get em /order
    public ResponseEntity<List<Product>> findAll(){
        // na camada atual de controller, eu chamo a camada de serviços, que por sua vez, chama o repository que
        // retorna a lista de pedidos
        List<Product> categoryList = productService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
