package com.nihil.springintro.services;

import com.nihil.springintro.entities.User;
import com.nihil.springintro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra como um COMPONENTE SERVICE para poder ser utilizado pelo autowired em alguma classe que possa vir a
// depender dele
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
