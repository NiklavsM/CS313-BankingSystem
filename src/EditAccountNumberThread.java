public class EditAccountNumberThread extends Thread {

    private BankAccount account;
    private String accountNumber;

    public EditAccountNumberThread(BankAccount account,String accountNumber) {
        this.account = account;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        account.setAccountNumber(accountNumber);
    }

}
