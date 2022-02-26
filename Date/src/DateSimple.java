import java.util.Date;

public class DateSimple {
	
	public static void main(String[] args) {
		
		Date d = new Date();
		d.setTime(d.getTime()+3600L*1000*24*180);
		System.out.println(d);
		
		
	}
}
