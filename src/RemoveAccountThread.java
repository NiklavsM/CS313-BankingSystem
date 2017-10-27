public class RemoveAccountThread extends Thread {
    IAccount account;
    AccountManager accountManager;
    public RemoveAccountThread(IAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.removeAccount(account);
    }
}
