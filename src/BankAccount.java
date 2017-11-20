import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BankAccount {

    private String accountNumber;
    private BankCustomer accountHolder;
    private Lock accountHolderLock = new ReentrantLock();
    private Lock accountNumberLock = new ReentrantLock();


    public BankAccount(String accountNumber) {

        this.accountNumber = accountNumber;
    }


    public String getAccountNumber() {
        accountNumberLock.lock();
        try {
            return accountNumber;
        } finally {
            accountNumberLock.unlock();
        }
    }


    public void setAccountNumber(String accountNumber) {
        accountNumberLock.lock();
        try {
            System.out.println("Previous account number: " + this.accountNumber);
            this.accountNumber = accountNumber;
            System.out.println("New account number: " + this.accountNumber);
        } finally {
            accountNumberLock.unlock();
        }
    }

    public void setAccountHolder(BankCustomer customer) {
        accountHolderLock.lock();
        try {
            accountHolder = customer;
        } finally {
            accountHolderLock.unlock();
        }
    }

    public BankCustomer getAccountHolder() {
        accountHolderLock.lock();
        try {
            return accountHolder;
        } finally {
            accountHolderLock.unlock();
        }

    }

    public abstract void addFunds(double extraFunds);

    public abstract boolean subtractFunds(double minusFunds) throws InterruptedException;

    public abstract double getBalance();

    public abstract void setBalance(double newBalance);
}
