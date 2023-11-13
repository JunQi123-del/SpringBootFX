package JavaModule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeProgram {

	public static int counter = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable changeLabel = new Runnable() {
			public void run() {
				if(counter!=0) {
				System.out.println("The label is changed to: " + counter);
				counter--;
				}else {
					Thread.currentThread().interrupt();
				}
				

			}
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(changeLabel, 0, 1, TimeUnit.SECONDS);

	}

}
