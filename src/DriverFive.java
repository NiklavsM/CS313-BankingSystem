public class DriverFive {
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
        MakeDepositThread makeDepositThread2 = new MakeDepositThread(checkingAccount2, 20);

        TransferFundsThread transferFundsThread = new TransferFundsThread(checkingAccount,checkingAccount2,12);

        MakeDepositThread makeDepositThread3 = new MakeDepositThread(checkingAccount, 5);

        TransferFundsThread transferFundsThread2 = new TransferFundsThread(checkingAccount,checkingAccount2,4);
        TransferFundsThread transferFundsThread3 = new TransferFundsThread(checkingAccount,checkingAccount2,5);

        makeDepositThread1.start();
        makeDepositThread2.start();
        transferFundsThread.start();
        makeDepositThread3.start();
        transferFundsThread2.start();
        transferFundsThread3.start();

        CreateAccountThread createAccount = new CreateAccountThread(new JointAccount("sdasdasd"),accountManager);

        //TODO: Differing results when more than 1 transfer //NMS fixed?
    }
}