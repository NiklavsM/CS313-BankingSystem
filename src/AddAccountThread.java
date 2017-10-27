public class AddAccountThread extends Thread {
    IAccount account;
    AccountManager accountManager;
    public AddAccountThread(IAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.addAccount(account);
    }
}
