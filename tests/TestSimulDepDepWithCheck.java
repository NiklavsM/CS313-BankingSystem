public class TestSimulDepDepWithCheck {

        public static void main(String[] args) {
            //Set up
            JointAccount ja1 = new JointAccount("123");

            //Tests
            MakeDepositThread mdt1 = new MakeDepositThread(ja1, 20.00);
            MakeDepositThread mdt2 = new MakeDepositThread(ja1, 20.00);
            CheckBalanceThread cbt1 = new CheckBalanceThread(ja1);
            MakeWithdrawalThread mwt1 = new MakeWithdrawalThread(ja1, 20.00);
            mdt1.start();
            mdt2.start();
            cbt1.start();
            mwt1.start();

        }

}
