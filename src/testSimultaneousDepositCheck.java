public class testSimultaneousDepositCheck {
    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");

        //Tests
        CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
        CheckBalanceThread cbt2 = new CheckBalanceThread(ja1);
        MakeDepositThread mdt1 = new MakeDepositThread(ja1, 20.00);
        MakeDepositThread mdt2 = new MakeDepositThread(ja1, 20.00);

        mdt1.start();
        mdt2.start();
        cbt1.start();
        cbt2.start();
    }
}
