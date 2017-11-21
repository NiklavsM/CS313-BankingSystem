import tm.*;
import java.awt.*;

public class DriverCombined {
    public static void main(String[] args) {
        System.out.println("Starting.");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    System.out.println("Setting up controller");
                    new TMController();
                    DriverOne.main(null);
                    DriverTwo.main(null);
                    DriverThree.main(null);
                    DriverFour.main(null);
                    DriverFive.main(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
