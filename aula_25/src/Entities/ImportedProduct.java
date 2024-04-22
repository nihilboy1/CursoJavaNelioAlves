package Entities;

public class ImportedProduct extends Product{
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee(){
        return customsFee;
    }

    @Override
    public String priceTag(){
        return super.getName() + " $" + super.getPrice() + " (Customs fee: $" + this.getCustomsFee() + ")";
    }
}
