package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Reader {

	public static void main(String[] args) {
		testReader();
	}

	private static void testReader() {
		
		try(
			FileInputStream fis = new FileInputStream("out.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		){
			System.out.println(ois.readObject());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
