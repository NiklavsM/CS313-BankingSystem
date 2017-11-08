public class TransferFundsThread extends Thread {

    IAccount accountSender;
    IAccount accountReciever;
    double amount;
    public TransferFundsThread(IAccount accountSender, IAccount accountReciever, double amount){
        this.accountSender = accountSender;
        this.accountReciever = accountReciever;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            accountSender.transferFunds(amount,accountReciever);
        }
        catch (InterruptedException ex){
            System.out.println("Cant wait no longer - transfer unsuccessful");
        }
    }

}
