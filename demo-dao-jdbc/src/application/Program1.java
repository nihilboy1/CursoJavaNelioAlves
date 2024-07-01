package application;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.util.List;

public class Program1{
    public static void main(String[] args){
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

        // System.out.println();
        // System.out.println("=== TESTE N1: department insert -");
        // Department department = departmentDAO.insert("adm");
        // System.out.println(department);

        System.out.println();
        System.out.println("=== TESTE N2: department findById -");
        Department department1 = departmentDAO.findById(3);
        System.out.println(department1);

        System.out.println();
        System.out.println("=== TESTE N3: department delete -");
        // departmentDAO.deleteById(2);

        System.out.println();
        System.out.println("=== TESTE N4: department findAll -");
        List<Department> departmentList = departmentDAO.findAll();
        for(Department department : departmentList){
            System.out.println(department);
        }

        System.out.println();
        System.out.println("=== TESTE N5: department update -");
        Department department2 = new Department(1, "Computers");
        departmentDAO.update(department2);
    }
}