public class TestWithdraw {
    public static void main(String[] args){
        JointAccount ja1 = new JointAccount("123");
        ja1.addFunds(100);

        //Tests
        MakeWithdrawalThread mwt1 = new MakeWithdrawalThread(ja1,20);
        MakeWithdrawalThread mwt2 = new MakeWithdrawalThread(ja1,10);

        mwt1.start();
        mwt2.start();
    }
}
