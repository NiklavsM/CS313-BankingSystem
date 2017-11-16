public class MakeDepositThread extends Thread {
    private BankAccount account;
    private double amount;
    public MakeDepositThread(BankAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.addFunds(amount);
    }
}
