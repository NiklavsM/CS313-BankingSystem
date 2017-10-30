public class DriverFour {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        IAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        IAccount savingAccount = new SavingAccount("njisnjdfnjsndfjnj2434");
        accountManager.addAccount(checkingAccount);
        accountManager.addAccount(savingAccount);
        //######################### Checking ########################################
        // Ordinary Tests for Checking
        MakeDepositThread makeDepositThread1 = new MakeDepositThread(checkingAccount, 10);
        MakeDepositThread makeDepositThread2 = new MakeDepositThread(checkingAccount, 20);
        MakeDepositThread makeDepositThread3 = new MakeDepositThread(checkingAccount, 40);
        MakeWithdrawalThread withdraw = new MakeWithdrawalThread(checkingAccount, 70);

        makeDepositThread1.start();
        makeDepositThread2.start();
        makeDepositThread3.start();
        withdraw.start();
    }
}
