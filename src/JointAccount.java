import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JointAccount extends CheckingAccount implements IJointAccount {
    private List<BankCustomer> accountHolders = new LinkedList<>();
    private Lock accountHoldersLock = new ReentrantLock();

    public JointAccount(String accountNumber) {
        super(accountNumber);
    }

    public void addToAccountHolders(BankCustomer customer) {
        accountHoldersLock.lock();
        try {
            accountHolders.add(customer);
        } finally {
            accountHoldersLock.unlock();
        }
    }

    public void removeFromAccountHolders(BankCustomer customer) {
        accountHoldersLock.lock();
        try {
            accountHolders.remove(customer);
        } finally {
            accountHoldersLock.unlock();
        }
    }

    public List getAccountHolders() {
        return new LinkedList(accountHolders);
    }
}
