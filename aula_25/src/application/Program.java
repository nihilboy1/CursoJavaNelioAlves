package application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> productList = new ArrayList<>();
        int numberOfProducts;
        System.out.print("Enter the number of products: ");
        while(true){
            try{
                numberOfProducts = Integer.parseInt(sc.nextLine());
                break;
            }catch(Exception exception){
                System.out.println("Invalid input");
            }
        }

        for(int i = 0; i < numberOfProducts; i++){
            System.out.println("Product #" + (i + 1) + " data: ");
            System.out.print("Common, used or imported (c, u, i)? ");
            String commonUsedOrImported = sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();

            if(Objects.equals(commonUsedOrImported, "i")){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                sc.nextLine();
                productList.add(new ImportedProduct(productName, productPrice, customsFee));
            }else if(Objects.equals(commonUsedOrImported, "u")){
                System.out.print("Manufacture date: ");
                String manufactureDate = sc.nextLine();
                productList.add(new UsedProduct(productName, productPrice, LocalDate.parse(manufactureDate)));
            }else if(Objects.equals(commonUsedOrImported, "c")){
                productList.add(new Product(productName, productPrice));
            }
        }

        for(Product product : productList){
            System.out.println(product.priceTag());
            ;
        }

        sc.close();
    }
}