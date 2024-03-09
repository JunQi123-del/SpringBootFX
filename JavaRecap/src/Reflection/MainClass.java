package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
	
	public static void main(String [] args) {
		Cat myPet = new Cat("Bobby",4);
		
		Field [] myPetFields = myPet.getClass().getDeclaredFields();
		
		for(Field petField:myPetFields) {
			if(petField.getName().equalsIgnoreCase("Name")) {
				petField.setAccessible(true); //set the field to be able to access from reflect
				try {
					petField.set(myPet, "OdenKirk");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("My pet name is: "+myPet.getName());
		
		Method[] myPetMethods = myPet.getClass().getDeclaredMethods();
		for(Method catMeth:myPetMethods) {
//			System.out.println(catMeth.getName());
			if(catMeth.getName().equals("heyThisIsPrivate")) {
				try {
					catMeth.setAccessible(true);
					catMeth.invoke(myPet);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	

}
