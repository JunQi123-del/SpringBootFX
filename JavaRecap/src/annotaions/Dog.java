package annotaions;

@VeryImportant
public class Dog {
	
	@ImportantString
	String name;
	
	int age;
	
	public Dog(String name) {
		this.name = name;

	}
	@RunImmediately(times=3)
	public void meow() {
		System.out.println("Woof!");
	}
	
	public void eat() {
		System.out.println("Nom Nom");
	}

}
