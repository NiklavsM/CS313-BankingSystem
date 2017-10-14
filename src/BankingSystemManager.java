import java.util.ArrayList;
import java.util.List;

public class BankingSystemManager {

    private List<BankEmployee> bankEmployees = new ArrayList<>();
    private List<BankCustomer> bankCustomers = new ArrayList<>();
    private AccountManager accountManager = new AccountManager();

    public void addBankEmployee(BankEmployee employee){
        bankEmployees.add(employee);
    }
    public void addBankCustomer(BankCustomer customer){
        bankCustomers.add(customer);
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }
}

