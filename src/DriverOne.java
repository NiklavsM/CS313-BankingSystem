public class DriverOne {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        IAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        IAccount savingAccount = new SavingAccount("njisnjdfnjsndfjnj2434");
        accountManager.addAccount(checkingAccount);
        accountManager.addAccount(savingAccount);
        //######################### Checking ########################################
        // Ordinary Tests for Checking
        MakeDepositThread makeDepositThread = new MakeDepositThread(checkingAccount, 100.12);
        MakeWithdrawalThread makeWithdrawalThread = new MakeWithdrawalThread(checkingAccount, 50);
        MakeWithdrawalThread mkwiththr = new MakeWithdrawalThread(checkingAccount, 10);

        makeDepositThread.start();
        makeWithdrawalThread.start();
        mkwiththr.start();
        //######################################################################
        //############################ Saving ####################################
        // Tests that Savings Account does not have overdraft functionality
        MakeDepositThread makeDepositThreadS = new MakeDepositThread(savingAccount, 100.12);
        MakeWithdrawalThread makeWithdrawalThreadS = new MakeWithdrawalThread(savingAccount, 50);
        MakeWithdrawalThread mkwiththrS = new MakeWithdrawalThread(savingAccount, 10000);

        makeDepositThreadS.start();
        makeWithdrawalThreadS.start();
        mkwiththrS.start();
        //#######################################################################
    }
}
