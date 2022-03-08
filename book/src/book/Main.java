package book;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

public class Main {

	public static void main(String[] args) {
		Stream<Integer> ints = 
				Stream
				.iterate(
						0, 
						n->n.compareTo(1000)<0, 
						n->Integer.sum(n, 1));
		
//		ints.forEach(System.out::println);
		
		
		
//		var summar = ints.collect(Collectors.summarizingLong((n)->n));
//		System.out.println(summar.getAverage());
//		System.out.println(summar.getMax());
//		System.out.println(summar.getMin());
//		System.out.println(summar.getCount());
//		System.out.println(summar.getSum());

		Optional<Integer> optional =  ints.reduce((x, y)->Integer.sum(x, y));
//		
		System.out.println(optional.get());
		
		LongStream is = LongStream.rangeClosed(0, 99990999L);
		System.out.println(is.max().getAsLong());
		
		
		
		String str = "Hello my friend! How do you do?";
		
		var as = Arrays.stream(str.split(" ")).parallel().filter(s->s.length()>3).collect(Collectors.groupingBy(String::length));
		
		System.out.println(as);
		
	}

}
