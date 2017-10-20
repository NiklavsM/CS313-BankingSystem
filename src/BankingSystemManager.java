import java.util.ArrayList;
import java.util.List;

public class BankingSystemManager {

    private List<BankEmployee> bankEmployees = new ArrayList<>();
    private List<BankCustomer> bankCustomers = new ArrayList<>();
    private AccountManager accountManager = new AccountManager();
    /**
     * assignedAccounts contains an arrayList of String[2] arrays.
     * They are formatted as such: [SystemUser id, BankAccount accountNumber]
     * assignedAccounts functions as a Map with multiple assignments possible
     */
    private ArrayList<String[]> assignedAccounts = new ArrayList<String[]>();

    public void addBankEmployee(BankEmployee employee){
        bankEmployees.add(employee);
    }
    public void addBankCustomer(BankCustomer customer){
        bankCustomers.add(customer);
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }
    public boolean assignAccount(String id, String accountNumber) {
        for(String[] line : assignedAccounts) {
            if(line[0].equals(id) && line[1].equals(accountNumber)) {
                return false;
            }
        }
        String[] newLine = new String[2];
        newLine[0] = id;
        newLine[1] = accountNumber;
        assignedAccounts.add(newLine);
        return true;
    }
}

