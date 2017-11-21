public class TestAddRemoveAccounts {
    public static void main(String[] args){

        //Set up
        AccountManager am = new AccountManager();
        JointAccount ja1 = new JointAccount("123");
        SavingAccount sa1 = new SavingAccount("124");
        am.addAccount(ja1);

        //Tests

        AddAccountThread addAccountThread1 = new AddAccountThread(sa1,am);
        RemoveAccountThread removeAccountThread2 = new RemoveAccountThread(ja1,am);

        addAccountThread1.start();
        removeAccountThread2.start();
    }
}
