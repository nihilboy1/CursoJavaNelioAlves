package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.util.*;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer numberOfInstallments){
        double noTaxesInstallment = contract.getTotalValue() / numberOfInstallments;
        for(int i = 1; i <= numberOfInstallments; i++){
            LocalDate installmentNextDate = contract.getExecutionDate().plusMonths(i);
            double interest = onlinePaymentService.interest(noTaxesInstallment, i);
            double installmentFinalAmount =
                    onlinePaymentService.paymentFee(interest + noTaxesInstallment) + noTaxesInstallment + interest;
            contract.getInstallments().add(new Installment(installmentNextDate, installmentFinalAmount)) ;
        }
    }


}
