package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true){
            System.out.println("INFORME UM NUMERO ENTRE 1 E 10: ");
            n = sc.nextInt();
            if (n >= 1 && n <= 10){
                break;
            }
        }

        Person[] vector = new Person[n];

        for (int i = 0; i < vector.length; i++) {
            System.out.println("DADOS DA PESSOA " + (i + 1));
            System.out.print("Nome: ");
            sc.nextLine(); // Para descartar a quebra de linha restante
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura: ");
            double height = sc.nextDouble();
            vector[i] = new Person(name, age, height);

        }

        double heightSum = 0;
        int youngerThan16 = 0;
        for(int i = 0; i <vector.length; i++){
            heightSum = heightSum + vector[i].getHeight();
            if (vector[i].getAge() < 16){
                youngerThan16 = youngerThan16 + 1;
            }
        }
        double avgHeight = heightSum / vector.length;
        double youngerThan16Percent =  ((double) youngerThan16 /  vector.length) * 100;
        System.out.printf("ALTURA MÉDIA: %.2f\n" , avgHeight);
        System.out.printf("MENORES DE 16 ANOS: %.2f%%\n", youngerThan16Percent );
        for(int i = 0; i <vector.length; i++){
            if (vector[i].getAge() < 16){
                String personName = vector[i].getName();
                System.out.println(personName);
            }
        }


        sc.close();
    }
}