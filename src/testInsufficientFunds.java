public class testInsufficientFunds {

    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");

        //Tests
        MakeDepositThread mdt1 = new MakeDepositThread(ja1,10);
        MakeWithdrawalThread mwt1 = new MakeWithdrawalThread(ja1,20);

        mdt1.start();
        mwt1.start();
    }

}
