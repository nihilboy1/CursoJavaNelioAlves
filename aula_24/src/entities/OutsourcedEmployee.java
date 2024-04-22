package entities;

public class OutsourcedEmployee extends Employee{
    private Double additionalCharge;

    public OutsourcedEmployee(String name, Integer workedHours, Double valuePerHour, Double additionalCharge){
        super(name, workedHours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        double bonus = additionalCharge + (additionalCharge * 10.00 / 100);
        return super.getValuePerHour() * super.getHour() + bonus;
    }
}
