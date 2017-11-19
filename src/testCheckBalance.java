public class testCheckBalance {

    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");
        ja1.addFunds(100.00);

        //Tests
        CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
        CheckBalanceThread cbt2 = new CheckBalanceThread(ja1);

        cbt1.start();
        cbt2.start();
    }

}
