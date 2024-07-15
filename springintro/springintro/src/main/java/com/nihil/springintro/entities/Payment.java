package com.nihil.springintro.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "paymentTb")
public class Payment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant instant;
    @OneToOne
    @MapsId
    private Order order;

    public Payment(){

    }

    public Payment(Long id, Instant instant, Order order){
        this.id = id;
        this.instant = instant;
        this.order = order;
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

    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getId());
    }
}
