package MultiThreading;

import java.util.*;

public class HackerCaseStudy {
	
	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String [] args) {
		Random random = new Random();
		
		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
		
		List<Thread> threads = new ArrayList<>();
		
		threads.add(new AscendingHackerThread(vault));
		threads.add(new DescendingHackerThread(vault));
		threads.add(new PoliceThread());
		
		for(Thread thread : threads) {
			thread.start();
		}
	}

}
