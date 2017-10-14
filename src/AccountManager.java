import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    List<IAccount> bankAccounts = new ArrayList<>();
    public void addAccount(IAccount account){
        bankAccounts.add(account);
    }
}
