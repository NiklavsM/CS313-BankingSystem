import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private Lock accountLock = new ReentrantLock();

    public void addAccount(BankAccount account) {
        accountLock.lock();
        try {
            bankAccounts.add(account);
            System.out.println("Account with number: " + account.getAccountNumber() + " has been created. Total number of accounts in account manager is: " + bankAccounts.size());
        } finally {
            accountLock.unlock();
        }
    }

    public void removeAccount(BankAccount account) {
        accountLock.lock();
        try {
            bankAccounts.remove(account);
            System.out.println("Account with number: " + account.getAccountNumber() + " has been removed. Total number of accounts in account manager is: " + bankAccounts.size());
        } finally {
            accountLock.unlock();
        }
    }

    /**
     * @param accountNumber
     * @return class type is the accountNumber is found, null if it is not found
     */
    public Class getAccountType(String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account.getClass();
            }
        }

        return null;
    }

    public boolean accountExists(String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }

        return false;
    }

}
