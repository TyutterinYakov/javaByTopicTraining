package Simple5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		List<MyCallable> calls = new ArrayList<>(); 
		for(int i=0; i<5; i++) {
			MyCallable my = new MyCallable();
			Future<Long> fu = es.submit(my);
			calls.add(my);
		}
		
//		for(Future<Long> f : tasks) {
//			System.out.println("Id thread: "+f.get());
//		}
		
//		List<Future<Long>> tasks =  es.invokeAll(calls);
//		tasks.stream().map((f)->{
//			try {
//				return f.get();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}).forEach(System.out::println);
		
		 Long l = es.invokeAny(calls);
		 System.out.println(l);
		 
		
		
		System.out.println("FINISH");
		es.shutdown();
		
	}
}

class MyCallable implements Callable<Long> {

	@Override
	public Long call(){
		try {
		System.out.println("Started: "+Thread.currentThread().getId());
		Thread.sleep(1000+Math.round(Math.random()*5000));
		System.out.println("Finished: "+Thread.currentThread().getId());
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
		return Thread.currentThread().getId();
	}
	
}
