package entitites;

public class Product{
    private String name;
    private Double price;

    public Product(String name, Double price){
        this.price = price;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }
}
