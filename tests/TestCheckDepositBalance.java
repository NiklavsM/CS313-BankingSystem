public class TestCheckDepositBalance {
    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");

        //Tests
        CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
        MakeDepositThread mdt2 = new MakeDepositThread(ja1, 20.00);

        cbt1.start();
        mdt2.start();
    }
}
