package com.nihil.springintro.repositories;

import com.nihil.springintro.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// recebe como parametro o tipo da entidade que ele representa e o tipo do identificador da entidade
public interface OrderRepository extends JpaRepository<Order, Long>{

    // não é necessário implementar nenhum método nessa interface, pois o JpaRepository já tem os métodos basicos do
    // crud, que vão receber como parametro o tipo passado pra ele
}
