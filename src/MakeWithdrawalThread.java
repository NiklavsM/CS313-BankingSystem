public class MakeWithdrawalThread extends Thread {
    IAccount account;
    double amount;
    public MakeWithdrawalThread(IAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.subtractFunds(amount);
        System.out.println("Witdrawn Thread id: " + Thread.currentThread().getId() + " account balance: " + account.getBalance());
    }
}
