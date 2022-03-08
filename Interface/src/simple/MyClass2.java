package simple;

public class MyClass2 implements MyInterface {

	@Override
	public void sayHello() {
		System.out.println("Hello2");
	}

	@Override
	public String getName() {
		return "MyClass2";
	}

}
