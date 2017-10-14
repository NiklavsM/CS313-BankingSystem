public class MakeDepositThread extends Thread {
    IAccount account;
    double amount;
    public MakeDepositThread(IAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.addFunds(amount);
        System.out.println("Deposit Thread id: " + Thread.currentThread().getId() + " account balance: " + account.getBalance());
    }
}
