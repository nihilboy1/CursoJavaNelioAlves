package entities;

import entities.enums.OrderStatus;

import java.util.Date;

public class Order{

    private Integer id;
    private Date instant;
    private OrderStatus status;


    public Order(){

    }

    public Order(Integer id, Date instant, OrderStatus status){
        this.id = id;
        this.instant = instant;
        this.status = status;
    }

    public Integer getId(){
        return id;
    }

    public Date getInstant(){
        return instant;
    }

    public OrderStatus getStatus(){
        return status;
    }
}
