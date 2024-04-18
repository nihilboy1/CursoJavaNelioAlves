package entities;

import java.time.LocalDate;
import java.util.Date;

public class Contract{

    private LocalDate date;
    private  Double valuePerHour;
    private Integer hours;

    public Contract(LocalDate date, Double valuePerHour, Integer hours){
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public LocalDate getDate(){
        return date;
    }

    public Double getValuePerHour(){
        return valuePerHour;
    }

    public Integer getHours(){
        return hours;
    }

    public double totalValue(){
        return valuePerHour * hours;
    }

    @Override
    public String toString(){
        return "Contract{" + "date=" + date + ", valuePerHour=" + valuePerHour + ", hours=" + hours + '}';
    }
}
