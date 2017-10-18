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
        //TODO: Still need to add checking for accounts with overdraft capability
        if(balance >= minusFunds) {
            balance = balance - minusFunds;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}
