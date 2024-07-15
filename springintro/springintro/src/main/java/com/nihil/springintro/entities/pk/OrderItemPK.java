package com.nihil.springintro.entities.pk;

import com.nihil.springintro.entities.Order;
import com.nihil.springintro.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable{
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode(){
        return Objects.hash(order, product);
    }
}
