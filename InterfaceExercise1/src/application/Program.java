package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com os dados do contrato.");

        System.out.print("Número: ");
        Integer contractNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Data de contratação (dd/MM/yyyy): ");
        LocalDate contractExecutionDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        Double contractValue = sc.nextDouble();
        sc.nextLine();
        ContractService contractService = new ContractService(new PaypalService());
        Contract contract = new Contract(contractNumber, contractExecutionDate, contractValue);


        System.out.print("Número de Parcelas: ");
        Integer numberOfInstallments = sc.nextInt();
        sc.nextLine();
        contractService.processContract(contract, numberOfInstallments);
        System.out.println("Parcelas:");
        for(Installment installmentData : contract.getInstallments() ){
            System.out.println(installmentData);
        }






        sc.close();
    }
}