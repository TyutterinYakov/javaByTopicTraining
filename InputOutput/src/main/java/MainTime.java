import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainTime {

	public static void main(String[] args) {
		LocalDate local = LocalDate.now();
		LocalDateTime localTime = LocalDateTime.now();
		double hours=150.9;
		System.out.println(local);
		System.out.println(localTime);
		Long minutes = (long) (hours*60L);
		System.out.println(localTime.minusMinutes(minutes));
		
		
	}
}
