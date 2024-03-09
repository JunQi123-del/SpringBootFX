package MultiThreading;

public class ThreadClass extends Thread{
	
	@Override
	public void run() {
		System.out.println("Hello from "+Thread.currentThread().getName());
	}

}
