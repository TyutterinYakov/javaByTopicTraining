
public class ThreadSynchro {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		for(int i=0; i<200; i++) {
			Process process = new Process(counter);
			new Thread(process).start();
		}
		Thread.sleep(1000);
		System.out.println( counter.getCounter());
		
	}
}

class Counter{
	
	private Long counter=0L;
	
	public synchronized void increase() {
		counter+=1L;
	}
	public Long getCounter() {
		return counter;
	}
	
}

class Process implements Runnable {
	
	private Counter counter;
	
	public Process(Counter counter) {
		this.counter=counter; 
	}
	
	@Override
	public void run() { 
		for(int i=0; i<1000; i++) {
			counter.increase();
		}
	}
	
	
}
