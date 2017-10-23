public class CheckingAccount extends BankAccount{


    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public boolean subtractFunds(double minusFunds) {
            setBalance(getBalance() - minusFunds);
            return true;
    }
}
