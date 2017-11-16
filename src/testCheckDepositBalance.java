public class testCheckDepositBalance {
    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");

        //Tests
        CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
        MakeDepositThread cbt2 = new MakeDepositThread(ja1, 20.00);
    }
}
