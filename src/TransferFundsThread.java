public class TransferFundsThread extends Thread {

    private IAccount accountSender;
    private IAccount accountReciever;
    private double amount;
    public TransferFundsThread(IAccount accountSender, IAccount accountReciever, double amount){
        this.accountSender = accountSender;
        this.accountReciever = accountReciever;
        this.amount = amount;
    }

    //FIXME: Probably a better way of doing this - only works for 2 transfers currently// NMS I think its fixed now.
    @Override
    public void run() {

        try{
            if(accountSender.subtractFunds(amount)){
                accountReciever.addFunds(amount);
                System.out.println("accountReciever balance: " + accountReciever.getBalance());
            }

        }catch (InterruptedException e){
            System.out.println("Sender didnt have enough funds so transfer was aborted");
        }
        /*
        Thread[] ts = new Thread[activeCount()];
        boolean otherTransfer = false;
        Thread tt = null;
        if(enumerate(ts) > 0) {
            for(Thread t : ts) {
                if (t != null) {
                    if(t.getClass().equals(this.getClass()) && t.getId() < this.getId() && t.getState() == State.RUNNABLE) {
                        System.out.println("ANOTHER TRANSFER THREAD HAS BEEN FOUND!");
                        otherTransfer = true;
                        tt = t;
                    }
                }
            }
        }
        try {
            if(otherTransfer) {
                tt.join();
                System.out.println("Thread ID = " + this.getId() + " JUST JOINED WITH THREAD ID = " + tt.getId());
            }
            accountSender.transferFunds(amount, accountReciever);
        }
        catch (InterruptedException ex){
            System.out.println("Cant wait no longer - transfer unsuccessful");
        }
            */
    }


}
