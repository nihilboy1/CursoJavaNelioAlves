package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker{
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<Contract> contractList = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName(){
        return name;
    }

    public WorkerLevel getLevel(){
        return level;
    }

    public Double getBaseSalary(){
        return baseSalary;
    }

    public Department getDepartment(){
        return department;
    }

    public List<Contract> getContractList(){
        return contractList;
    }

    public void addContract(Contract contract){
        contractList.add(contract);
    }

    public void removeContract(Contract contract){
        contractList.remove(contract);
    }

    public double getIncome(LocalDate date){
        double contractsIncomes = 0;
        for (Contract contract: contractList){
            if(contract.getDate().getYear() == date.getYear()){
                if(contract.getDate().getMonth() == date.getMonth()){
                    contractsIncomes += contract.totalValue();
                }
            }
        }
        return contractsIncomes += baseSalary;
    }
}
