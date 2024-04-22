package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private final DateTimeFormatter CUSTOMFORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate manufactureDate;

    public UsedProduct(String name, double price, LocalDate manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate(){
        return manufactureDate;
    }

    @Override
    public String priceTag(){
        return super.getName() + " (Used) $" + super.getPrice() + " (Manufacture date: " + this.getManufactureDate().format(CUSTOMFORMAT) + ")";
    }
}
