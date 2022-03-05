package simple;

public class ThreadSynchroTwo {

	public static void main(String[] args) throws InterruptedException {
		for(int i=0; i<3; i++) {
			Process process = new Process();
			new Thread(process).start();
		}
		Thread.sleep(1000);
	}
}

class Process implements Runnable {
	
	private String name = null;
	
	@Override
	public void run() {
		System.out.println(name.length());
	}
	
	
}
