package entities;

public class BusinessAccount extends Account{
    private double loanLimit;

    public BusinessAccount(Integer number, String holder, double balance, double loanLimit){
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount){
        if(amount <= loanLimit){
            super.balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        this.balance -= 2;
    }
}
