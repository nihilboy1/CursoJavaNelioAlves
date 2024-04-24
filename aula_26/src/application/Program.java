package application;

import entities.CompanyTaxPayer;
import entities.IndividualTaxPayer;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("tax payers: ");
        int numberOfTaxPayers = sc.nextInt();
        List<TaxPayer> taxPayerList = new ArrayList<>();
        for(int i = 0; i < numberOfTaxPayers; i++){
            sc.nextLine();

            System.out.print("(i / c): ");
            char individualOrCompany = sc.nextLine().charAt(0);

            System.out.print("name: ");
            String name = sc.nextLine();

            System.out.print("anual income: ");
            double anualIncome = sc.nextDouble();

            if(individualOrCompany == 'i'){
                System.out.print("health Expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayerList.add(new IndividualTaxPayer(name, anualIncome, healthExpenditures));
            }else if(individualOrCompany == 'c'){
                System.out.print("number Of Employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayerList.add(new CompanyTaxPayer(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println("TAXES PAID: ");
        double totalTaxes = 0;
        for(TaxPayer taxPayer : taxPayerList){
            System.out.println(taxPayer.getName() + ": $" + taxPayer.calculateTax());
            totalTaxes += taxPayer.calculateTax();
        }
        System.out.println("TOTAL TAXES: " + totalTaxes);

        sc.close();
    }
}