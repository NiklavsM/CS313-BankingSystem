import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoDAccount extends BankAccount implements IInterestAccumulation {
    private double balance = 0.0;
    private Calendar untilDate;
    private Lock fundsLock = new ReentrantLock();
    private Condition con = fundsLock.newCondition();
    private double interestRate = 0;

    public CoDAccount(String accountNumber, int yearUntil, int monthUntil, int dayUntil) {
        super(accountNumber);
        this.untilDate = new GregorianCalendar(yearUntil, monthUntil, dayUntil);
    }

    public void changeUntilDate(int year, int month, int day) {
        this.untilDate = new GregorianCalendar(year, month, day);
    }
    public void addFunds(double extraFunds) {
        fundsLock.lock();

        try {
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() +"  Funds to be added: " + extraFunds + " |  balance before: " + getBalance());
            setBalance(getBalance() + extraFunds);
            System.out.println("Deposit Thread id: " + Thread.currentThread().getId() +" Balance after: " + getBalance());
        }
        finally{
            fundsLock.unlock();
        }
    }

    @Override
    public boolean subtractFunds(double minusFunds) throws InterruptedException {
        Calendar currentDate = Calendar.getInstance();
        boolean stillWaiting = true;

        if (currentDate.after(untilDate)) {
            fundsLock.lock();
            try {

                while (getBalance() < minusFunds) {
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

        return false;

    }
    public void setInterestRate(double interest){
        interestRate = interest;
    }

    public double getBalance() {
        fundsLock.lock();
        try {
            return balance;
        } finally {
            fundsLock.unlock();
        }
    }

    public void printBalance() {
        fundsLock.lock();
        try {
            System.out.println("Accounts : " + getAccountNumber() + " balance is: " + balance);
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
}
