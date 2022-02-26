import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		MyClass m1 = new MyClass(1L,"YYYY");
		MyClass m2 = new MyClass(1L,"YYYY");
		if(m1.equals(m2)) {
			System.out.println("OK");
			System.out.println(m1.hashCode());
			System.out.println(m2.hashCode());
		}
		System.out.println(m1==m2);
		
		Set<MyClass> mys = new HashSet<>();
		mys.add(m1);
		mys.add(m2);
		System.out.println(mys);
		
	}
	
	
	

	
}
