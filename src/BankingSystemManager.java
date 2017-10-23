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

    public BankingSystemManager() {

    }

    public void addBankEmployee(BankEmployee employee){
        bankEmployees.add(employee);
    }
    public void addBankCustomer(BankCustomer customer){
        bankCustomers.add(customer);
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }


    /**
     *
     * Assigns SystemUsers and BankAccounts to each other.
     *
     * Does not allow more than a 1:1 (BankAccount:SystemUser) relationship unless the BankAccount is a JointAccount,
     * in which it allows 1:M (BankAccount:SystemUser) relationship
     *
     * @param id - the ID of the SystemUser
     * @param accountNumber - the Account Number of the BankAccount
     * @return - True if assign is successful, False if assign is unsuccessful
     */
    public boolean assignAccount(String id, String accountNumber) {
        if(accountManager.accountExists(accountNumber)) {
            if(userAccountExists(id)) {

                int isJointResult = isJoint(accountNumber);
                if(isJointResult == 1 || isJointResult == -1) { //is joined account
                    for(String[] line : assignedAccounts) {
                        if(isJointResult == 1) {
                            if(line[0].equals(id) && line[1].equals(accountNumber)) {
                                System.out.println("Joint Account is already assigned to that ID!");
                                return false;
                            }
                        } else { // isJointResults == -1
                            if(line[0].equals(id) && line[1].equals(accountNumber)) {
                                System.out.println("Account is already assigned to that ID!");
                                return false;
                            } else if (!(line[0].equals(id)) && line[1].equals(accountNumber)) {
                                System.out.println("Account is already assigned to a different User! ID: " + line[0] + " !");
                                return false;
                            }
                        }
                    }
                    String[] newLine = new String[2];
                    newLine[0] = id;
                    newLine[1] = accountNumber;
                    assignedAccounts.add(newLine);
                    System.out.println("Successfully assigned ID: " + id + ", with account number: " + accountNumber + " !");
                    return true;

                } else { //result == 0 aka account not found
                    System.out.println("Account was not found! Cannot assign!");
                    return false;
                }
            } else {
                System.out.println("User Account does not exist! Cannot Assign!");
            }



        } else {
            System.out.println("Bank Account does not exist! Cannot Assign!");
            return false;
        }

        return false;

    }

    public int isJoint(String accountNumber) {
        Class result = accountManager.getAccountType(accountNumber);
        if(result != null) {
            JointAccount ja = new JointAccount("");
            if(accountManager.getAccountType(accountNumber).equals(ja.getClass())) {
                return 1;
            }
        } else if(result == null) { //Account not found
            return 0;
        } else { //Found but and not a JointAccount
            return -1;
        }


        return -1;
    }

    private boolean userAccountExists(String id) {
        for(SystemUser user : bankCustomers) {
            if(user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

}

