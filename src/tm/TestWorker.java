package tm;

public class TestWorker implements Runnable{
    public void run(){
        boolean run = true;
        while (run){
            try{
                Thread.sleep(1000);

                for (int i = 0; i < 100000; i++){

                }
            } catch (InterruptedException e){
                run = false;
            }
        }
    }


}
