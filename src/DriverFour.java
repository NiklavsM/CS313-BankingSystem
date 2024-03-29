//These are tests just for testing extra part, tests for marking are found in "tests folder"
public class DriverFour {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        BankAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        BankAccount checkingAccount2 = new CheckingAccount("OV18HABAHA123231213");
        BankAccount savingAccount = new SavingAccount("njisnjdfnjsndfjnj2434");
        accountManager.addAccount(checkingAccount);
        accountManager.addAccount(checkingAccount2);
        accountManager.addAccount(savingAccount);
        //######################### Checking ########################################
        // Ordinary Tests for Checking
        MakeDepositThread makeDepositThread1 = new MakeDepositThread(checkingAccount, 10);
        MakeDepositThread makeDepositThread2 = new MakeDepositThread(checkingAccount, 20);
        MakeDepositThread makeDepositThread3 = new MakeDepositThread(checkingAccount, 40);
        MakeDepositThread makeDepositThread4 = new MakeDepositThread(checkingAccount2, 10);
        MakeWithdrawalThread withdraw = new MakeWithdrawalThread(checkingAccount, 70);
        MakeWithdrawalThread withdraw2 = new MakeWithdrawalThread(checkingAccount2, 20);

        makeDepositThread1.start();
        makeDepositThread2.start();
        makeDepositThread3.start();
        makeDepositThread4.start();
        withdraw.start();
        withdraw2.start();
    }
}
