package simple3;

import java.util.concurrent.Callable;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("START: "+ Thread.currentThread().getClass().getCanonicalName());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("FINISH: "+ Thread.currentThread().getClass().getCanonicalName());
		
	}



}
