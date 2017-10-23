public abstract class BankAccount implements IAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber){
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public void addFunds(double extraFunds) {
        balance = balance + extraFunds;
    }

    /**
     *
     * @param minusFunds
     * @return
     */
    public boolean subtractFunds(double minusFunds) {
        if(balance >= minusFunds) {
            balance = balance - minusFunds;
            return true;
        } else {
            System.out.println("Insufficient funds to subtract funds!");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    //for use within override methods
    public void setBalance(double newBalance) {balance = newBalance;}
    public String getAccountNumber(){
        return accountNumber;
    }
}
