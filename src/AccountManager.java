import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    List<IAccount> bankAccounts = new ArrayList<>();
    public void addAccount(IAccount account){
        bankAccounts.add(account);
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
