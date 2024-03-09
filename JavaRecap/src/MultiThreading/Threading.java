package MultiThreading;

import java.lang.runtime.*;

public class Threading {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("We are now in thread "+Thread.currentThread().getName());
				System.out.println("The current thread priority is: "+Thread.currentThread().getPriority());
				
				throw new RuntimeException("Intentional Exception");
			}
		});
		thread.setName("Worker thread");

		// set to highest priority
		thread.setPriority(Thread.MAX_PRIORITY);
		
		//catching exception thrown out by the thread
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("A critical error happened in thread "+t.getName()+" the error is "
						+e.getMessage());
			}
		});
		
		// Starts the thread
		thread.start(); 
	}

}
