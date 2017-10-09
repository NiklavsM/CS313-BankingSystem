public class BankAccount implements Account {

    private Details details;
    private double balance;
    private String accountType;

    @Override
    public void setAccountType(String type) {

    }

    @Override
    public void setBalance(double newBalance) {

    }

    @Override
    public void setOwnerDetails(Details details) {

    }

    public BankAccount(double balance) {
        setAccountType("Bank");
        setOwnerDetails(new Details());
    }


    @Override
    public String getAccountType() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public Details getOwnerDetails() {
        return null;
    }
}
