public class testCheckBalance {

    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");

        //Tests
        CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
        CheckBalanceThread cbt2 = new CheckBalanceThread(ja1);
    }

}
