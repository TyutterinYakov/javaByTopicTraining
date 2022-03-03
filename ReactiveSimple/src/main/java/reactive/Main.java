package reactive;

import reactive.spec.Publisher;

public class Main {

	public static void main(String[] args) {
		
//		var res = Publisher.defer(()->Publisher.just(1, 2, 3)) 
//					.peek(System.out::println)
//					.map((i)->(i+1))
//					.peek(System.out::println)
//					.collect();
		
		var res = Publisher.from(()->1) 
				.peek(System.out::println)
				.map((i)->(i+1))
				.peek(System.out::println)
				.collect();
		
		System.out.println(res);
		
		
	}
}
