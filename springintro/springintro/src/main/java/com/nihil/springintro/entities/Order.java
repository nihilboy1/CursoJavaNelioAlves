package com.nihil.springintro.entities;

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
    private Instant instant;

    @ManyToOne // indica que haverão muitos Order para 1 User
    @JoinColumn(name = "ClientId")
    private User client;

    public Order(){

    }

    public Order(Long id, Instant instant, User client){
        this.id = id;
        this.instant = instant;
        this.client = client;
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
