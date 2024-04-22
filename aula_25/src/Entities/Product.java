package Entities;

public class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String priceTag(){
        return this.name + " $" + this.price;
    }
}
