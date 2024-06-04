package Interfacing;


public class InterfaceImplementation implements simpleInterface{
	
	@Override
	public void print() {
		
	}
	
	@Override
	public <T> void sumOfType(T object1, T object2) {
		
		System.out.println("Java cannot add both generic type together: "+object1+object2);
	}

}
