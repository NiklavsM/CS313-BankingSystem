
public class MakeWithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;
    public MakeWithdrawalThread(BankAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            account.subtractFunds(amount);
        }
        catch (InterruptedException ex){
            System.out.println("Cant wait no longer - withdrawn unsuccessful");
        }
        System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + ", account balance: " + account.getBalance());
    }
}
