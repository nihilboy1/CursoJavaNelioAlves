package app;

import entitites.Product;

import java.util.*;

public class Main{
    public static void main(String[] args){
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("10", 800.00));
        productList.add(new Product("1", 900.00));
        productList.add(new Product("3", 800.00));
        productList.add(new Product("2", 1000.00));
        productList.add(new Product("0", 800.00));

        /*
        Por que não Precisa Passar os Dois Argumentos Diretamente?
        No código que você mencionou, você não está passando explicitamente os dois argumentos
        (p1 e p2) para a lambda porque o método Comparator.comparing já cuida disso para você
        internamente. O Java sabe que um Comparator precisa comparar dois objetos e, portanto,
        quando você usa Comparator.comparing, ele espera que a lambda que você fornece receba
        um único argumento (o objeto p) e retorne o valor a ser comparado.
        Então, mesmo que você não veja explicitamente p1 e p2 na lambda, o Java os passa automaticamente nos bastidores sempre que o Comparator precisa comparar dois elementos na lista.
        */

        // expressões lambda no java são tratadas como interfaces funcionais
        productList.sort(Comparator.comparing(p -> p.getName().toUpperCase()));
        for(Product product : productList){
            System.out.println(product.getName());
        }




    }
}