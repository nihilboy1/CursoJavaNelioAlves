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

    public List<Installment> processContract(Contract contract, Integer numberOfInstallments){
        double noTaxesInstallment = contract.getTotalValue() / numberOfInstallments;
        List<Installment> installmentsList = new ArrayList<>();
        for(int i = 0; i < numberOfInstallments; i++){
            LocalDate installmentNextDate = contract.getExecutionDate().plusMonths(i+1);
            double installmentFinalAmount = onlinePaymentService.paymentFee(onlinePaymentService.interest(noTaxesInstallment,
                    i + 1));
            Installment installment = new Installment(installmentNextDate, installmentFinalAmount);
            installmentsList.add(installment);
        }

        return installmentsList;
    }


}
