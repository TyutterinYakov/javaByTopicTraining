package serializ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Main {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, ClassNotFoundException {
		User user = new User();
		user.setDateOfBirth(LocalDate.now());
		user.setId(1L);
		user.setPassword("2332332");
		user.setUserName("AAAAAAAA");
		System.out.println(user);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("User.out"));
		out.writeObject(user);
		out.close();
		
		TimeUnit.SECONDS.sleep(3);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("User.out"));
		System.out.println(in.readObject());
	}
}
