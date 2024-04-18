package application;

import entities.Contract;
import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentsName = sc.nextLine();
        System.out.println("- ENTER WORKER DATA");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), sc.nextDouble(), new Department(departmentsName));
        System.out.print("How many contracts to this worker? ");
        int contractsAmount = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < contractsAmount; i++){
            System.out.printf("Enter the contract #%d data\n", (i + 1));
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            LocalDate formatedDate = LocalDate.parse(date, customFormat);
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            worker.addContract(new Contract(formatedDate, valuePerHour, hours));
            sc.nextLine();
        }
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String incomeDate = sc.nextLine();
        System.out.println(worker.getName());
        System.out.print("Department: ");
        System.out.println(worker.getDepartment().getName());
        System.out.printf("Income for " + incomeDate + ": %.2f", worker.getIncome(LocalDate.parse("01/" + incomeDate,
                customFormat)));
        System.out.print("Name: ");
        sc.close();
    }
}