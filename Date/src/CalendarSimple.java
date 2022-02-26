import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarSimple {

	
	
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
		
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
		
		Arrays.asList(TimeZone.getAvailableIDs()).stream().forEach(System.out::println);
		
		Arrays.asList(Locale.getAvailableLocales()).stream().forEach(System.out::println);
		
		
	}
}
