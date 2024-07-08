package com.nihil.springintro.controllers;

import com.nihil.springintro.entities.Order;
import com.nihil.springintro.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // declara que essa classe é um COMPONENTE CONTROLLER rest
@RequestMapping(value = "/orders")
public class OrderController{
    @Autowired
    private OrderService orderService;

    @GetMapping // declara que esse método responde ao get em /order
    public ResponseEntity<List<Order>> findAll(){
        // na camada atual de controller, eu chamo a camada de serviços, que por sua vez, chama o repository que
        // retorna a lista de pedidos
        List<Order> userList = orderService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
