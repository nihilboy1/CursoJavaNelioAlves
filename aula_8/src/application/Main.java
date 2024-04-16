package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        double price = sc.nextDouble();
        int quantityInStock = sc.nextInt();
        Product product = new Product(name, price, quantityInStock);

        product.showProductData();

        System.out.println("Enter the product amount to be added in stock");
        product.IncreaseQuantity(sc.nextInt());
        product.showProductData();

        System.out.println("Enter the product amount to be removed from stock");
        product.DecreaseQuantity(sc.nextInt());
        product.showProductData();
    }
}