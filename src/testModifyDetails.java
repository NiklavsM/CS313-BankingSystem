public class testModifyDetails {
    public static void main(String[] args) {
        //Set up
        BankCustomer bc1 = new BankCustomer("123");
        bc1.getDetails().setName("ted");

        //Tests
        EditDetailsThread edt1 = new EditDetailsThread("name","bob", bc1);
        EditDetailsThread edt2 = new EditDetailsThread("name","jim", bc1);

        edt1.start();

        try {
            edt1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        edt2.start();

        try {
            edt2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
