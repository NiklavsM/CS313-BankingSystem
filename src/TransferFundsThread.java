public class TransferFundsThread extends Thread {

    private BankAccount accountSender;
    private BankAccount accountReceiver;
    private double amount;

    public TransferFundsThread(BankAccount accountSender, BankAccount accountReceiver, double amount) {
        this.accountSender = accountSender;
        this.accountReceiver = accountReceiver;
        this.amount = amount;
    }

    //FIXME: Probably a better way of doing this - only works for 2 transfers currently// NMS I think its fixed now.
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
