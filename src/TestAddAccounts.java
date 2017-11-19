public class TestAddAccounts {
    public static void main(String[] args){

        //Set up
        AccountManager am = new AccountManager();
        JointAccount ja1 = new JointAccount("123");
        SavingAccount sa1 = new SavingAccount("124");

        //Tests

        AddAccountThread addAccountThread1 = new AddAccountThread(ja1,am);
        AddAccountThread addAccountThread2 = new AddAccountThread(sa1,am);

        addAccountThread1.start();
        addAccountThread2.start();
    }
}
