package socket;

public class SimpleClient {
	
	public static void main(String[] args) {
		for(int i=0; i<200; i++) {
			new SimpleClientThread().start();
		}
	}
}


