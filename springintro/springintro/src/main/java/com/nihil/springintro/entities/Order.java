package com.nihil.springintro.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nihil.springintro.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "OrderTb")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instant;

    private Integer orderStatus;

    @ManyToOne // indica que haverão muitos Order para 1 User
    @JoinColumn(name = "ClientId")
    private User client;

    public Order(){

    }

    public Order(Long id, Instant instant, OrderStatus orderStatus, User client){
        this.id = id;
        this.instant = instant;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Instant getInstant(){
        return instant;
    }

    public void setInstant(Instant instant){
        this.instant = instant;
    }

    public User getClient(){
        return client;
    }

    public void setClient(User client){
        this.client = client;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getId());
    }
}