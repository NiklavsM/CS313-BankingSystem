import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavingAccount extends BankAccount implements IInterestAccumulation {

    private double interestRate = 0;
    private Lock fundsLock = new ReentrantLock();
    private Condition con = fundsLock.newCondition();
    private double minimumBalance = 0;

    public SavingAccount(String accountNumber) {
        super(accountNumber);
    }
    public void setInterestRate(double interest){
        interestRate = interest;
    }


    public void addInterest(){
        fundsLock.lock();
        try {
            double currentBalance = getBalance();
            setBalance(currentBalance + currentBalance * interestRate);
        }
        finally {
            fundsLock.unlock();
        }
    }
    public void addFunds(double extraFunds) {
        fundsLock.lock();

        try {
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() + "  Funds to be added: " + extraFunds + " |  balance before: " + getBalance());
            setBalance(getBalance() + extraFunds);
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() + " Balance after: " + getBalance());
        } finally {
            fundsLock.unlock();
        }
    }

    public boolean subtractFunds(double minusFunds) throws InterruptedException {
        boolean stillWaiting = true;

        fundsLock.lock();
        try {
            while (getBalance() - minimumBalance < minusFunds) {
                if (!stillWaiting) {
                    Thread.currentThread().interrupt();
                }
                stillWaiting = con.await(3, TimeUnit.SECONDS);
            }
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + "  minusFunds : " + minusFunds);
            setBalance(getBalance() - minusFunds);
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + "  balance left : " + getBalance());
        } finally {
            fundsLock.unlock();
        }
        System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + "  Finished");
        return true;
    }

    public void setMinimumBalance(double minimumBalance){
        this.minimumBalance = minimumBalance;
    }
}
