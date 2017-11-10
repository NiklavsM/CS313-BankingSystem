import java.util.List;

public abstract class BankAccount {

    private double balance;
    private String accountNumber;
    private BankCustomer accountHolder;

    public BankAccount(String accountNumber) {
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountHolder(BankCustomer customer){
        accountHolder = customer;
    }
    public BankCustomer getAccountHolder(){
        return accountHolder;
    }
    public abstract void addFunds(double extraFunds);
    public abstract boolean subtractFunds(double minusFunds) throws InterruptedException;
}
