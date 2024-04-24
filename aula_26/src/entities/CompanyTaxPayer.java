package entities;

public class CompanyTaxPayer extends TaxPayer{
    private int numberOfEmployees;

    public CompanyTaxPayer(String name, double anualIncome, int numberOfEmployees){
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    @Override
    public double calculateTax(){
        if(numberOfEmployees > 10){
            return (getAnualIncome() * 0.14);
        }
        return (getAnualIncome() * 0.16);
    }
}
