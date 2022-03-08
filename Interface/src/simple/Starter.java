package simple;

public class Starter {

	public static void main(String[] args) {
		MyInterface mi = MyInterface.getInstance(MyClass1.class.getName());
		mi.sayHello();
	}
}
