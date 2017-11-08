import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BankAccount implements IAccount {

    public double balance;
    public String accountNumber;
    Lock lock = new ReentrantLock();
    Condition con = lock.newCondition();

    public BankAccount(String accountNumber){
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public void addFunds(double extraFunds) {
        Lock lock = new ReentrantLock();
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
    public void subtractFunds(double minusFunds) throws InterruptedException {
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
    }

    public double getBalance() {
        return balance;
    }

    //for use within override methods
    public void setBalance(double newBalance) {balance = newBalance;}

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

    public String getAccountNumber(){
        return accountNumber;
    }
}
