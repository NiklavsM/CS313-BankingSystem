public class CheckBalanceThread extends Thread {

    private BankAccount bankAccount;

    public CheckBalanceThread(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Accounts : " + bankAccount.getAccountNumber() + " balance is: " + bankAccount.getBalance());

    }
}
