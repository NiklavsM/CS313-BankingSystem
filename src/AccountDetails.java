import java.util.LinkedList;
import java.util.List;

public class AccountDetails {
    private List<BankCustomer> accountHolders = new LinkedList<>();

    public void addAccountHolder(BankCustomer accountHolder){
        accountHolders.add(accountHolder);
    }
}
