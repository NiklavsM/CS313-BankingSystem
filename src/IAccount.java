public interface IAccount {
    void addFunds(double amount);

    boolean subtractFunds(double amount) throws InterruptedException;
    double getBalance();
    String getAccountNumber();
    // NMS  public void transferFunds(double transferFunds, IAccount reciever) throws InterruptedException;

}
