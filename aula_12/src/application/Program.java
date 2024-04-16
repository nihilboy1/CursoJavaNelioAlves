package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("INFORME O 'N': ");
        int n = sc.nextInt();

        Product[] vect = new Product[n];


        for(int i = 0; i < vect.length; i++){
            sc.nextLine();
            System.out.printf("INFORME O NOME DO PRODUTO %d: " , i +1 );
            String name = sc.nextLine();
            System.out.printf("INFORME O PREÇO DO PRODUTO %d: " , i +1 );
            double price = sc.nextDouble();
            vect[i] = new Product(name, price);
        }


        double sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + vect[i].getPrice();
        }
        double averagePrice = sum / n;
        System.out.printf("averagePrice: " + averagePrice);
        sc.close();
    }
}