package entities;

public class Account{
    protected double balance;
    private Integer number;
    private String holder;

    public Account(Integer number, String holder, double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber(){
        return number;
    }

    public String getHolder(){
        return holder;
    }

    public final double getBalance(){
        return balance;
    }

    public void withdraw(double amount){
        balance -= amount + 5.0;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
