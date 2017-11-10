public class CreateAccountThread extends Thread {
    IAccount account;
    AccountManager accountManager;
    public CreateAccountThread(IAccount accountToAdd, AccountManager manager){
        account = accountToAdd;
        accountManager = manager;
    }
    @Override
    public void run() {
        accountManager.addAccount(account);
        System.out.println("Thread id: " + getId() + ", Created account id: " + account.getAccountNumber());
    }
}
