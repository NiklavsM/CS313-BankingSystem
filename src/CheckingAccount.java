import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckingAccount extends BankAccount{

    private double balance = 0.0;
    private Lock fundsLock = new ReentrantLock();
    private Condition con = fundsLock.newCondition();
    private double allowedOverdraft = 0;


    public CheckingAccount(String accountNumber) {
        super(accountNumber);
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
            while (getBalance() + allowedOverdraft < minusFunds) {
                if (!stillWaiting) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Was not enough funds, waits for 3 seconds for funds to become available");
                stillWaiting = con.await(3, TimeUnit.SECONDS);
            }
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + "  minusFunds : " + minusFunds);
            setBalance(getBalance() - minusFunds);
            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() + "  balance left : " + getBalance());
        } finally {
            fundsLock.unlock();
        }
        return true;
    }

    public double getBalance() {
        fundsLock.lock();
        try {
            return balance;
        } finally {
            fundsLock.unlock();
        }
    }

    public void setBalance(double newBalance) {
        fundsLock.lock();
        try {
            balance = newBalance;
        } finally {
            fundsLock.unlock();
        }
    }

    public void setOverdraftAllowance(double allowance) {

            allowedOverdraft = allowance;

    }

    public double getOverdraftAllowance() {
        return allowedOverdraft;
    }

}
