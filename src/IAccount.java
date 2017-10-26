public interface IAccount {
    void addFunds(double amount);

    void subtractFunds(double amount) throws InterruptedException;
    double getBalance();
    String getAccountNumber();

}
