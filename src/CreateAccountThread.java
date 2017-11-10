public class CreateAccountThread extends Thread {
    private BankAccount account;
    private AccountManager accountManager;
    public CreateAccountThread(BankAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.addAccount(account);
        System.out.println("Thread id: " + getId() + ", Created account id: " + account.getAccountNumber());
    }
}
