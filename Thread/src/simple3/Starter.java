package simple3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Starter {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10, new MyFactory());
		
		for(int i=0; i<20; i++) {
			es.submit(new MyRunnable());
		}
		es.shutdown();
		
		
	}
}



class MyFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		return new SingleThread(r);
	}
}

class SingleThread extends Thread {

	public SingleThread(Runnable target) {
		super(target);
	}

	
}
