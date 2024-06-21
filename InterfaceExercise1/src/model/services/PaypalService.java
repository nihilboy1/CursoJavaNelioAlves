package model.services;

public class PaypalService implements OnlinePaymentService{

    public Double paymentFee(Double amount){
        return amount + (amount * 2 / 100);
    };

    public Double interest(Double amount, Integer currentInstallment){
        return amount + ((amount * 1 / 100) * currentInstallment);
    }

}
