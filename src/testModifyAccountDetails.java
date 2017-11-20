public class testModifyAccountDetails {
    public static void main(String[] args) {
        //Set up
        JointAccount ja1 = new JointAccount("123");


        //Tests
        EditAccountNumberThread edt1 = new EditAccountNumberThread(ja1,"444");
        EditAccountNumberThread edt2 = new EditAccountNumberThread(ja1,"555");

        edt1.start();
        edt2.start();

    }
}
