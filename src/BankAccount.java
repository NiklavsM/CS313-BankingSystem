public abstract class BankAccount implements IAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber){
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public synchronized void addFunds(double extraFunds) {
        balance = balance + extraFunds;
    }

    public synchronized void subtractFunds(double minusFunds) {
        balance = balance - minusFunds;
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}
