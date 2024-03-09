package MultiThreading;

public class DescendingHackerThread extends HackerThread{
	
	public final int MaxPassword = 9999;
	
	public DescendingHackerThread(Vault vault) {
		super(vault);
	}
	
	@Override
	public void run() {
		for(int guess = MaxPassword; guess >= 0;guess--) {
			if(vault.isPasswordCorrect(guess)) {
				System.out.println(this.getName() + "Guess the password "+guess);
				System.exit(0);
			}
		}
	}
	

}
