public class BankAccount implements IAccount {

    private double balance;
    public BankAccount(){

    }
    @Override
    public void setAccountType(String type) {

    }

    @Override
    public void setBalance(double newBalance) {

    }

    public BankAccount(double balance) {
        setAccountType("Bank");
    }


    @Override
    public String getAccountType() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
