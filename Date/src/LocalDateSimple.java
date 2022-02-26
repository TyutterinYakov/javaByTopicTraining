import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateSimple {

	
	
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.of(2001, 06, 8, 10, 45);
		System.out.println(ldt);
		
		LocalDate d = LocalDate.from(ldt);
		System.out.println(d);

		LocalDate ld = LocalDate.parse("2012-11-17");
		System.out.println(ld);
		System.out.println(ld.minusMonths(100));
		
		
	}
}
