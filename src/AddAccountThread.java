public class AddAccountThread extends Thread {
    private BankAccount account;
    private AccountManager accountManager;
    public AddAccountThread(BankAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.addAccount(account);
    }
}
