package com.nihil.springintro.services;

import com.nihil.springintro.entities.Product;
import com.nihil.springintro.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra como um COMPONENTE SERVICE para poder ser utilizado pelo autowired em alguma classe que possa vir a
// depender dele
public class ProductService{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(long id){
        Optional<Product> categoryOptional = productRepository.findById(id);
        return categoryOptional.get();
    }
}
