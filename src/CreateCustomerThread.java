public class CreateCustomerThread extends Thread {
    BankCustomer account;
    BankingSystemManager bankSystemManager;

    public CreateCustomerThread(BankCustomer customerToAdd, BankingSystemManager bankSystemManager){
        account = customerToAdd;
        this.bankSystemManager = bankSystemManager;
    }
    @Override
    public void run() {
        bankSystemManager.addBankCustomer(account);
        System.out.println("Thread id: " + getId() + ", Created account id: " + account.getId());
    }
}
