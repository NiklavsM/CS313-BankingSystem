public class TransferFundsThread extends Thread {

    private BankAccount accountSender;
    private BankAccount accountReceiver;
    private double amount;

    public TransferFundsThread(BankAccount accountSender, BankAccount accountReceiver, double amount) {
        this.accountSender = accountSender;
        this.accountReceiver = accountReceiver;
        this.amount = amount;
    }

    @Override
    public void run() {

        try {
            if (accountSender.subtractFunds(amount)) {
                accountReceiver.addFunds(amount);
                System.out.println("accountReceiver balance: " + accountReceiver.getBalance());
            }

        } catch (InterruptedException e) {
            System.out.println("Sender didnt have enough funds so transfer was aborted");
        }
    }


}
