package entities;

public class Product{
    private Integer amount;
    private Double price;
    private String name;

    public Product(Integer amount, Double price, String name){
        this.amount = amount;
        this.price = price;
        this.name = name;
    }

    public Integer getQuantity(){
        return amount;
    }

    public Double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public Double getSubTotal(){
        return this.amount * this.price;
    }

    @Override
    public String toString(){
        return this.name + ", $" + this.price + ", Amount: " + this.amount + ", Subtotal: $" + getSubTotal();
    }
}
