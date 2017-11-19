public class TestRemoveAccounts {
    public static void main(String[] args){

        //Set up
        AccountManager am = new AccountManager();
        JointAccount ja1 = new JointAccount("123");
        SavingAccount sa1 = new SavingAccount("124");
        am.addAccount(ja1);
        am.addAccount(sa1);

        //Tests

        RemoveAccountThread removeAccountThread1 = new RemoveAccountThread(ja1,am);
        RemoveAccountThread removeAccountThread2 = new RemoveAccountThread(sa1,am);

        removeAccountThread1.start();
        removeAccountThread2.start();
    }
}
