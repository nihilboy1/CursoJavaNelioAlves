package application;

import utils.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program{

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Whats is the dollar price? ");
        double dollarPrice = sc.nextDouble();

        System.out.println("How many dollar will be bought? ");
        double dollarToBeBought = sc.nextDouble();

        System.out.printf("Amount to be paid in reais: " + CurrencyConverter.dollarToReal(dollarPrice, dollarToBeBought));

        sc.close();
    }
}
