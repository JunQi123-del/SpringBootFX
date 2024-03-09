package annotaions;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatingAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog myDog = new Dog("GiGi");

		if (myDog.getClass().isAnnotationPresent(VeryImportant.class)) {
			System.out.println("This thing is very important");
		} else {
			System.out.println("This thing is not very important");
		}

		for (Method dogMeth : myDog.getClass().getDeclaredMethods()) {
			if (dogMeth.isAnnotationPresent(RunImmediately.class)) {
				try {
					RunImmediately annotation = dogMeth.getAnnotation(RunImmediately.class);
					for (int i = 0; i < annotation.times();i++) {
						dogMeth.invoke(myDog);
					}
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
		
		for (Field dogField:myDog.getClass().getDeclaredFields()) {
			if(dogField.isAnnotationPresent(ImportantString.class)) {
				try {
					Object objectValue = dogField.get(myDog);
					if(objectValue instanceof String stringValue) {
						System.out.println(stringValue.toUpperCase());
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
