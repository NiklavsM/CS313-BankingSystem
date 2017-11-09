public class CheckingAccount extends BankAccount{


    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

//    public void subtractFunds(double minusFunds) throws InterruptedException {
//        boolean stillWaiting = true;
//        lock.lock();
//        try {
//
//            while (balance < (minusFunds - 10)) {
//                if(!stillWaiting){
//                    Thread.currentThread().interrupt();
//                }
//                stillWaiting = con.await(3, TimeUnit.SECONDS);
//            }
//            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  minusFunds : " + minusFunds);
//            balance = balance - minusFunds;
//            System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  balance left : " + balance);
//        }  finally{
//            lock.unlock();
//        }
//        System.out.println("Withdrawn Thread id: " + Thread.currentThread().getId() +"  Finished");
//    }

}
