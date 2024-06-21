package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Integer number;
    private LocalDate executionDate;
    private Double totalValue;
    private List<Installment> installments;

    public Contract(Integer number, LocalDate executionDate, Double totalValue) {
        this.number = number;
        this.executionDate = executionDate;
        this.totalValue = totalValue;
        this.installments = new ArrayList<>();  // Inicializa a lista de installments
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }

    public void addInstallment(Installment installment) {
        this.installments.add(installment);
    }
}
