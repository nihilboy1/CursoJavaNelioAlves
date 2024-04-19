package application;

import entities.Client;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter CLIENT data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Enter ORDER data: ");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), new Client(clientName, clientEmail, clientBirthDate));

        System.out.print("How many ITEMS to this order? ");
        int quantityOfItemsInTheOrder = sc.nextInt();

        for(int i = 0; i < quantityOfItemsInTheOrder; i++){
            sc.nextLine();
            System.out.println("Enter #" + (i + 1) + " product data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Product amount: ");

            Integer productAmount = sc.nextInt();
            order.addProduct(new Product(productAmount, productPrice, productName));
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order Moment: " + order.getMoment().format(customFormat));
        System.out.println("Order Status: " + order.getStatus());
        System.out.println("Client: " + order.getClient());
        System.out.println("ORDER ITEMS: ");
        for(Product product : order.getProducts()){
            System.out.println(product);
        }
        System.out.println("Total Price: $" + order.getTotalPrice());

        sc.close();
    }
}