package MultiThreading;

public class AscendingHackerThread extends HackerThread{
	public final int MaxPassword = 9999;
	
	public AscendingHackerThread(Vault vault) {
		super(vault);
	}
	
	@Override
	public void run() {
		for(int guess = 0; guess < MaxPassword;guess++) {
			if(vault.isPasswordCorrect(guess)) {
				System.out.println(this.getName() + "Guess the password "+guess);
				System.exit(0);
			}
		}
	}

}
