package simple;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Example4 {

	public static void main(String[] args) {
		Client client = new Client("Yasha", 33, true);
		addHello(client::getName, client::setName);
		System.out.println(client.getName());
		
	}
	
	
	public static void addHello(Supplier<String> supplier, Consumer<String> consumer) {
		consumer.accept("Hello "+supplier.get());
	}
}
