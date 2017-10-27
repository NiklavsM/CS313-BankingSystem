import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {
    List<IAccount> bankAccounts = new ArrayList<>();
    Lock lock = new ReentrantLock();
    public void addAccount(IAccount account){
        lock.lock();
        try {
            bankAccounts.add(account);
        }
        finally {
            lock.unlock();
        }
    }

    public void removeAccount(IAccount account) {
        lock.lock();
        try {
            bankAccounts.remove(account);
        }
        finally {
            lock.unlock();
        }
    }

    /**
     *
     * @param accountNumber
     * @return class type is the accountNumber is found, null if it is not found
     */
    public Class getAccountType(String accountNumber) {
        for(IAccount account : bankAccounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account.getClass();
            }
        }

        return null;
    }

    public boolean accountExists(String accountNumber) {
        for(IAccount account : bankAccounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }

        return false;
    }
}
