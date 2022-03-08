package simple2;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Start thread" + getId());
		try {
			Thread.sleep(5000);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Finish thread" + getId());
	}

	
	
}
