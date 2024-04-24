package entities;

public class IndividualTaxPayer extends TaxPayer{
    private double healthExpenditures;

    public IndividualTaxPayer(String name, double anualIncome, double healthExpenditures){
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double getHealthExpenditures(){
        return healthExpenditures;
    }

    @Override
    public double calculateTax(){
        if(getAnualIncome() < 20000.0){
            return getAnualIncome() * 0.15 - getHealthExpenditures() * 0.5;
        }
        return getAnualIncome() * 0.25 - getHealthExpenditures() * 0.5;
    }
}
