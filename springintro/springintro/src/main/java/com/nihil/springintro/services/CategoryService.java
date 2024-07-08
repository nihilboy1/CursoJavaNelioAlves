package com.nihil.springintro.services;

import com.nihil.springintro.entities.Category;
import com.nihil.springintro.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra como um COMPONENTE SERVICE para poder ser utilizado pelo autowired em alguma classe que possa vir a
// depender dele
public class CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.get();
    }
}
