public interface IAccount {
    void addFunds(double amount);

    void subtractFunds(double amount) throws InterruptedException;
    double getBalance();
    String getAccountNumber();
    public void transferFunds(double transferFunds, IAccount reciever) throws InterruptedException;

}
