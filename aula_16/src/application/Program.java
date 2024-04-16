package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            System.out.println("Employee #" + (i + 1) + ": ");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("NAME: ");
            String name = sc.nextLine();
            System.out.print("SALARY: ");
            double salary = sc.nextDouble();
            employeeList.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee ID that will have salary increse: ");
        int id = sc.nextInt();
        Employee employeeForSalaryIncrease =
                employeeList.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
        if (employeeForSalaryIncrease == null){
            System.out.print("THIS ID DOES NOT EXIST");
            return;
        }
        System.out.print("Enter the percentage: ");
        double percentage = sc.nextDouble();

        System.out.println("LIST OF EMPLOYEES: ");
        for(Employee employee : employeeList){
            if (employee.getId() == employeeForSalaryIncrease.getId()){
                employee.increaseSalary(percentage);
            }
            System.out.println(employee);
        }
        sc.close();
    }
}