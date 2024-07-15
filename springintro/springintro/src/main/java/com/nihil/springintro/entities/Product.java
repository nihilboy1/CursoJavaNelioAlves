package com.nihil.springintro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ProductTb")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> orderItemSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ProductCategoryTb", joinColumns = @JoinColumn(name = "ProductId"), inverseJoinColumns = @JoinColumn(name = "CategoryId"))
    private Set<Category> categories = new HashSet<>();

    public Product(){
    }

    public Product(Long id, String name, String description, Double price, String imgUrl){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public String getImgUrl(){
        return imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories(){
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> orderSet = new HashSet<>();
        for(OrderItem orderItem : orderItemSet){
            orderSet.add(orderItem.getOrder());
        }
        return orderSet;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
