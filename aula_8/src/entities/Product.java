package entities;

public class Product{
    private String name;
    private double price;
    private int quantityInStock;

    public Product(String name, double price, int quantityInStock){
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    
    public int getQuantityInStock(){
        return this.quantityInStock;
    }

    public double TotalValueInStock(){
        return price * quantityInStock;
    }

    public void IncreaseQuantity(int amountToBeAdded){
        quantityInStock = quantityInStock + amountToBeAdded;
    }

    public void DecreaseQuantity(int amountToBeRemoved){
        quantityInStock = quantityInStock - amountToBeRemoved;
    }

    public void showProductData(){
        System.out.printf("Product Data: %s, $%.2f, %d units. Total: %.2f%n", name, price, quantityInStock, TotalValueInStock());
    }
}
