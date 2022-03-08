package simple4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		Future<Long> f = es.submit(new MyCallable());

		
		Thread.sleep(1000);
//		while(!f.isDone()) {
//			System.out.println("Is not done");
//			Thread.sleep(1000);
//		}
//		System.out.println(f.get(3, TimeUnit.SECONDS));

		f.cancel(true);
		
		System.out.println(f.isCancelled());
		
		System.out.println("Shutdown");
		
		es.shutdown();
		
	}
}


class MyCallable implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		System.out.println("Start: "+Thread.currentThread().getId());
		Thread.sleep(5000);
		System.out.println("Finish: "+Thread.currentThread().getId());
		return 9993299329329L;
	}

	
}


//class MyRunnable implements Runnable{
//
//	@Override
//	public void run() {
//		try {
//			System.out.println("Started: "+Thread.currentThread().getId());
//			Thread.sleep(5000);
//			System.out.println("Finished: "+Thread.currentThread().getId());
//		}catch(Exception ex) {
//			ex.printStackTrace(System.out);
//		}
//		
//	}
//	
//}
