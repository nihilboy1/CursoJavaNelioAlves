package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order{
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<Product> products = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment(){
        return moment;
    }

    public Client getClient(){
        return client;
    }

    public List<Product> getProducts(){
        return products;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void addProduct(Product item){
        products.add(item);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product : this.products){
            totalPrice += product.getSubTotal();
        }
        return totalPrice;
    }
}
