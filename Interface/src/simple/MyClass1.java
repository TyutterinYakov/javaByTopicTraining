package simple;

public class MyClass1 implements MyInterface {

	@Override
	public void sayHello() {
		System.out.println("Hello1");
		
	}

	@Override
	public String getName() {
		return "MyClass1";
	}

}
