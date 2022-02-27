import java.util.List;

public class All {

	
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of(3,4,56,6,565,56,6,5,65,6,5,56,65);
		
		int count =0;
		int count1 = 0;
		Integer variable;
		
		while(true) {
			try {
				list.get(count+2);
			} catch(ArrayIndexOutOfBoundsException ex) {
				variable =list.get(count1++);
				break;
			}
		}
		
		System.out.println(variable);
		
	}
	
}
