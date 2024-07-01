package application;

import domain.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Person p1 = new Person(1, "Carlos", "carlos@gmail.com");
        Person p2 = new Person(1, "Luiz", "luiz@gmail.com");
        Person p3 = new Person(1, "Maria", "maria@gmail.com");


        sc.close();
    }
}