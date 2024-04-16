package application;

import entities.Room;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Room[] rooms = new Room[10];

        System.out.println("How many rooms will be rented? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("RENT #"+ (i + 1));
            sc.nextLine();
            System.out.print("NAME: ");
            String tenantName = sc.nextLine();
            System.out.print("EMAIL: ");
            String tenantEmail = sc.nextLine();
            System.out.print("ROOM NUMBER (0 ~ 9): ");
            int number = sc.nextInt();
            rooms[number] = new Room(tenantName, tenantEmail, number);
        }


        System.out.println("BUSY ROOMS: ");
        for(Room room : rooms){
            if(room != null){
                System.out.println(room);
            }
        }


        sc.close();
    }
}