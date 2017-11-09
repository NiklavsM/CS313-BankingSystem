import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BankAccount implements IAccount {

    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    public BankAccount(String accountNumber){
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public void addFunds(double extraFunds) {
        lock.lock();

        try {
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() +"  Funds to be added: " + extraFunds + " |  balance before: " + balance);
            balance += extraFunds;
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() +" Balance after: " + balance);
        }
        finally{
            lock.unlock();
        }
    }

    /**
     *
     * @param minusFunds
     * @return
     */
    public boolean subtractFunds(double minusFunds) throws InterruptedException {
        boolean stillWaiting = true;
        lock.lock();
        try {

            while (balance < minusFunds) {
                if(!stillWaiting){
                    Thread.currentThread().interrupt();
                }
                stillWaiting = con.await(3, TimeUnit.SECONDS);
            }
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  minusFunds : " + minusFunds);
            balance = balance - minusFunds;
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  balance left : " + balance);
        }  finally{
            lock.unlock();
        }
        System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  Finished");
        return true;
    }

    public double getBalance() {
        return balance;
    }

    //for use within override methods
    public void setBalance(double newBalance) {balance = newBalance;}

    /* NMS - I think we dont need this method as it from here we cant ensure thread safety, instead we could make transfer thread use addFunds subtractFunds which will ensure thread safety
    public void transferFunds(double transferFunds, IAccount reciever) throws InterruptedException {
        boolean stillWaiting = true;
        lock.lock();
        try {
            while (balance < transferFunds) {
                if(!stillWaiting){
                    Thread.currentThread().interrupt();
                }
                stillWaiting = con.await(3, TimeUnit.SECONDS);
            }
            System.out.println("Transfer Thread id: " + Thread.currentThread().getId() +"  minusFunds : " + transferFunds);
            balance = balance - transferFunds;
            reciever.addFunds(transferFunds);
            System.out.println("Transfer Thread id: " + Thread.currentThread().getId() +"  balance left : " + balance + ", reciever balance : " + reciever.getBalance());
        }  finally{
            lock.unlock();
        }
        System.out.println("Transfer Thread id: " + Thread.currentThread().getId() +"  Finished");
    }
    */

    public String getAccountNumber(){
        return accountNumber;
    }
}
