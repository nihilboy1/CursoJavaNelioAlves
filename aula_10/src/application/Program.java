package application;

import entities.Account;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("CREATE ACCOUNT SYSTEM \n");
        System.out.println("Enter account number: ");
        int accountId = sc.nextInt();

        System.out.println("Enter account holder name: ");
        String accountHolderName = sc.nextLine();
        Account account = new Account(accountId, accountHolderName);
        sc.nextLine();

        System.out.println("Will there be an initial deposit (y/n)? ");
        char willThereBeAnInitialDeposit = sc.next().charAt(0);
        if (willThereBeAnInitialDeposit == 'y'){
            System.out.println("Enter initial deposit: ");
            double initalDeposit = sc.nextDouble();
            account.addFunds(initalDeposit);
        }

        System.out.println("ACCOUNT DATA:");
        account.showData();

        System.out.println("Enter a value to deposit: ");
        double valueToDeposit = sc.nextDouble();
        account.addFunds(valueToDeposit);
        System.out.println("UPDATED ACCOUNT DATA:");
        account.showData();

        System.out.println("Enter a value to withdraw: ");
        double valueToWithdraw = sc.nextDouble();
        account.withdrawFunds(valueToWithdraw);
        System.out.println("UPDATED ACCOUNT DATA:");
        account.showData();




        sc.close();
    }
}