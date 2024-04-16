package entities;

public class Account{
    private int id;
    private String holderName;
    private double balance;
    private final double TAX = 5.00;

    public Account(int id, String holderName, double initialDeposit){
        this.id = id;
        this.holderName = holderName;
        addFunds(initialDeposit);
    }

    public Account(int id, String holderName){
        this.id = id;
        this.holderName = holderName;
    }

    public void setHolderName(String holderName){
        this.holderName = holderName;
    }

    public int getId(){
        return id;
    }

    public String getHolderName(){
        return holderName;
    }

    public double getBalance(){
        return balance;
    }

    public void addFunds(double amountToBeDeposited ){
        balance = balance + amountToBeDeposited;
    }

    public void withdrawFunds(double amountToBeRemoved ){
        balance = balance - (amountToBeRemoved + TAX);
    }

    public void showData(){
        System.out.printf("Account ID: %d, Holder Name: %s, Balance $%.2f \n", id,
                holderName, balance);
    }
}
