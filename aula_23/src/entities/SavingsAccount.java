package entities;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(Integer number, String holder, double balance, double interestRate){
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void updateBalance(){
        super.balance += super.balance * interestRate;
    }

    @Override
    public void withdraw(double amount){
        balance -= amount;
    }
}


