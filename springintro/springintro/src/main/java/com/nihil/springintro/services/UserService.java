package com.nihil.springintro.services;

import com.nihil.springintro.entities.User;
import com.nihil.springintro.repositories.UserRepository;
import com.nihil.springintro.services.exceptions.ControllerNotFoundException;
import com.nihil.springintro.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return userOptional.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ControllerNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try{
            User refUser = userRepository.getReferenceById(id);
            updateData(refUser, user);
            return userRepository.save(refUser);
        }catch(EntityNotFoundException e){
            throw new ControllerNotFoundException(id);
        }
    }

    private void updateData(User refUser, User user){
        refUser.setName(user.getName());
        refUser.setEmail(user.getEmail());
        refUser.setPhone(user.getPhone());
    }
}
