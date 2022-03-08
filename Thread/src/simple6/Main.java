package simple6;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		ThreadPoolExecutor es = new ThreadPoolExecutor(
						2, 4, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2), 
						new MyReject()
					);
		
		for(int i=0; i<10; i++) {
			MyCallable my = new MyCallable();
			es.submit(my);
		}
		es.shutdown();
	}
}


class MyReject implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("REJECTED");
	}
	
}


class MyCallable implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		try {
			System.out.println("Thread started: "+Thread.currentThread().getId());
			Thread.sleep(3000);
			System.out.println("Thread finished: "+Thread.currentThread().getId());
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
		return Thread.currentThread().getId();
	}
	
}