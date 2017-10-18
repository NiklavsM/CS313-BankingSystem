public interface IAccount {
    void addFunds(double amount);

    boolean subtractFunds(double amount);
    double getBalance();

}
