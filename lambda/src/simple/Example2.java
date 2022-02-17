package simple;

public class Example2 {

	@FunctionalInterface
	interface Function<T1, T2, R>{
		R apply(T1 a, T2 b);
	}
	
	public static void main(String[] args) {
		Function<Integer, Integer, Integer> function = (x, y) -> x+y;
		Function<Integer, Integer, Integer> function1 = Integer::sum;
		System.out.println(function.apply(2, 3));
		System.out.println(function1.apply(2, 3));
	}
}
