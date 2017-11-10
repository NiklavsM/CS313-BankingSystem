public class RemoveAccountThread extends Thread {
    private  BankAccount account;
    private AccountManager accountManager;
    public RemoveAccountThread(BankAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.removeAccount(account);
    }
}
