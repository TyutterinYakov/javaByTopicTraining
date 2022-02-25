package instance;

import java.lang.reflect.Constructor;

public class Starter {
	
	public static void main(String[] args) throws Exception {
		
		String name="YYYYYY";
		Class<First> firstCl = First.class;
//		First f = firstCl.newInstance();
		Constructor<First> constructor = firstCl.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		First f = constructor.newInstance(name);
		
		
//		Constructor<First> constructor = firstCl.getDeclaredConstructor();
//		
//		First f = constructor.newInstance();
		
		System.out.println(f.getName());
		
	}
}
