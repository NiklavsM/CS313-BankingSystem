package tm;

import java.awt.*;

public class DriverPartB {

	public static void main(String[] args) {
		System.out.println("Starting.");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Setting up controller");
					new TMController();
					new DummyGroups();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
