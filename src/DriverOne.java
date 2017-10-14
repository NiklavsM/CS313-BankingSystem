public class DriverOne {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        IAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        accountManager.addAccount(checkingAccount);
        
        MakeDepositThread makeDepositThread = new MakeDepositThread(checkingAccount, 100.12);
        MakeWithdrawalThread makeWithdrawalThread = new MakeWithdrawalThread(checkingAccount, 50);

        makeDepositThread.start();
        makeWithdrawalThread.start();

    }
}
