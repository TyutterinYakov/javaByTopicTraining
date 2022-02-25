package reflection;
import java.lang.reflect.Field;

public class Starter {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		Class<?> cl = Class.forName("First");
		First o = (First)cl.newInstance();
		Field field = cl.getDeclaredField("name");
		field.setAccessible(true);
//		field.set(o, "name");
		System.out.println(o.getName());

		
		
		
		
		Class<?> cl1 = Class.forName("Second");
		Second s = (Second)cl1.newInstance();
		Field field2 = cl1.getDeclaredField("name2");
		Field field1 = cl1.getSuperclass().getDeclaredField("name");
		field2.setAccessible(true);
		field2.set(s, "Hello");
		field1.setAccessible(true);
		field1.set(s, "Yasha");
		System.out.println(s.getName());
		System.out.println(s.getName2());
		
//		System.out.println(Object.class.getSuperclass());
		
		
		
		
	}
}
