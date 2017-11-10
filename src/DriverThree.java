public class DriverThree {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        BankAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        BankAccount savingAccount = new SavingAccount("njisnjdfnjsndfjnj2434");
        accountManager.addAccount(checkingAccount);
        accountManager.addAccount(savingAccount);

        //######################### Checking ########################################
        // Ordinary Tests for Checking
        MakeWithdrawalThread makeWithdrawalThread = new MakeWithdrawalThread(checkingAccount, 100);
        MakeDepositThread makeDepositThread1 = new MakeDepositThread(checkingAccount, 1);
        MakeDepositThread makeDepositThread2 = new MakeDepositThread(checkingAccount, 20);
        MakeDepositThread makeDepositThread3 = new MakeDepositThread(checkingAccount, 40);

        makeWithdrawalThread.start();
        makeDepositThread1.start();
        makeDepositThread2.start();
        makeDepositThread3.start();

    }
}


