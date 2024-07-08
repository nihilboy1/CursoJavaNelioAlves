package com.nihil.springintro.services;

import com.nihil.springintro.entities.Order;
import com.nihil.springintro.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra como um COMPONENTE SERVICE para poder ser utilizado pelo autowired em alguma classe que possa vir a
// depender dele
public class OrderService{
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.get();
    }
}
