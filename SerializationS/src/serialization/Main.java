package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		testWrite();
//		testRead();
	}

//	private static void testRead() {
//		try(
//			FileInputStream fis = new FileInputStream("out.dat");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//		){
//			System.out.println(ois.readObject());
//			
//			
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//		
//	}

	private static void testWrite() {
		SecondSerial second = new SecondSerial();
		second.setId("qwerty");
		second.setFirstName("FistName");
		second.setLastName("LastName");
//		second.setProcessor(new ProcessorImpl());
		second.setSecondFirstName("YASHA");
		second.setSecondLastName("Tyutterin");
		second.setSecondId("zxcv");
		
		
		try(
			FileOutputStream fos = new FileOutputStream("out.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(second);
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
