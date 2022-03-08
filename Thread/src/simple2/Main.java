package simple2;

public class Main {
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			MyThread th = new MyThread();
			th.start();
		}
		for(int i=0; i<10; i++) {
			MyRunnable rn = new MyRunnable();
			new Thread(rn).start();
		}
		
	}
}
