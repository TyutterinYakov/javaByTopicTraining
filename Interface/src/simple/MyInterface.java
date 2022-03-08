package simple;

import java.util.ServiceLoader;

public interface MyInterface {

	void sayHello();
	
	String getName();
	
	public static MyInterface getInstance(String name) {
		ServiceLoader<MyInterface> services = ServiceLoader.load(MyInterface.class);
		for(MyInterface inst: services) {
			if(inst.getName().equals(name)) {
				return inst;
			}
		}
		throw new RuntimeException("No such implementation"+name);
	}
}
