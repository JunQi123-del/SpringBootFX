package MultiThreading;

public class Vault {
	
	private int password;
	
	public Vault(int password) {
		this.password = password;
	}
	
	public boolean isPasswordCorrect(int guess) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.password == guess;
	}

}
