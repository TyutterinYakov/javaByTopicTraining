package serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import serialization.FirstSerial;


public class Writer {

	public static void main(String[] args) {
		testWrite();
		
	}
	
	
	private static void testWrite() {
		FirstSerial first = new FirstSerial();
		first.setId("12345");
		first.setFirstName("Yasha");
		first.setLastName("Tyutterin");
		try(
			FileOutputStream fos = new FileOutputStream("out.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(first);
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
