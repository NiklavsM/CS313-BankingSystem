public class MakeDepositThread extends Thread {
    private IAccount account;
    private double amount;
    public MakeDepositThread(IAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.addFunds(amount);
    }
}
