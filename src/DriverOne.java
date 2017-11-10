public class  DriverOne {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        BankAccount checkingAccount = new CheckingAccount("LV18HABAHA123231213");
        BankAccount savingAccount = new SavingAccount("njisnjdfnjsndfjnj2434");
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

        // Error checking with BankingSystemManager
        //Following should output:
        /*
         * no account
         * no user
         * successfully assigned 21 and save
         * already linked between 21 and save
         * already linked to 21
         * successfully assigned 21 and joint
         * already linked 21 and joint
         * successfully assigned 22 and joint
         * already linked 22 and joint
         */
        BankingSystemManager bsm = new BankingSystemManager();
        bsm.assignAccount("21", "save");
        bsm.getAccountManager().addAccount(new SavingAccount("save"));
        bsm.assignAccount("21", "save");
        bsm.addBankCustomer(new BankCustomer("21"));
        bsm.assignAccount("21", "save");
        bsm.assignAccount("21", "save");
        bsm.addBankCustomer(new BankCustomer("22"));
        bsm.assignAccount("22", "save");
        bsm.getAccountManager().addAccount(new JointAccount("joint"));
        bsm.assignAccount("21","joint");
        bsm.assignAccount("21","joint");
        bsm.assignAccount("22","joint");
        bsm.assignAccount("22","joint");
        System.out.println(bsm.listBankAccounts("21"));

    }
}
