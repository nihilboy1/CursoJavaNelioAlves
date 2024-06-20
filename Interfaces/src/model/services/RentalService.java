package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService{
    private Double pricePerHour;
    private Double pricePerDay;
    private BrazilTaxService taxServices;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxServices){
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxServices = taxServices;
    }

    public void processInvoice(CarRental carRental){
            double rentalTime = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
            double rentalHours = rentalTime / 60;

            double basicPayment;
            if (rentalHours <= 12){
                basicPayment = pricePerHour * Math.ceil(rentalHours);
            }else {
                basicPayment = pricePerDay * Math.ceil(rentalHours / 24);
            }
            carRental.setInvoice(new Invoice(basicPayment, taxServices.brazilTax(basicPayment)));
    }


}
