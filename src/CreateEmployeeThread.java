public class CreateEmployeeThread extends Thread {
    BankEmployee account;
    BankingSystemManager bankSystemManager;

    public CreateEmployeeThread(BankEmployee employeeToAdd, BankingSystemManager bankSystemManager){
        account = employeeToAdd;
        this.bankSystemManager = bankSystemManager;
    }
    @Override
    public void run() {
        bankSystemManager.addBankEmployee(account);
        System.out.println("Thread id: " + getId() + ", Created account id: " + account.getId());
    }
}
