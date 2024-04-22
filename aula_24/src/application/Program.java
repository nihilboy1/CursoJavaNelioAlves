package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Employees: ");
        Integer numberOfEmployees = sc.nextInt();
        List<Employee> employeeList = new ArrayList<>();
        for(int i = 0; i < numberOfEmployees; i++){
            sc.nextLine();
            System.out.println("Employee #" + (i + 1) + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Worked hours: ");
            Integer workedHours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            if(outsourced == 'y'){
                System.out.print("Additional Charge: ");
                employeeList.add(new OutsourcedEmployee(name, workedHours, valuePerHour, sc.nextDouble()));
            }else{
                employeeList.add(new Employee(name, workedHours, valuePerHour));
            }
        }
        System.out.print('\n');
        System.out.println("PAYMENTS: ");
        for(Employee employee : employeeList){
            System.out.println(employee.getName() + " - $" + employee.payment());
        }

        sc.close();
    }
}