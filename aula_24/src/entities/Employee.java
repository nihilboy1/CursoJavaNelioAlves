package entities;

public class Employee{
    private String name;
    private Integer workedHours;
    private Double valuePerHour;

    public Employee(String name, Integer workedHours, Double valuePerHour){
        this.name = name;
        this.workedHours = workedHours;
        this.valuePerHour = valuePerHour;
    }

    public String getName(){
        return name;
    }

    public Integer getHour(){
        return workedHours;
    }

    public Double getValuePerHour(){
        return valuePerHour;
    }

    public Double payment(){
        return valuePerHour * workedHours;
    }
}
