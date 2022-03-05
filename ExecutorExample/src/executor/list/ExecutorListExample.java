package executor.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorListExample {
	
	public static void main(String[] args) {
		int ap = Runtime.getRuntime().availableProcessors();
		System.out.println("Количество процессоров: "+ap);
		
		ExecutorService es = Executors.newFixedThreadPool(ap);
		
		List<Future<String>> list = new ArrayList<>();
		for(int i=0; i<20; i++) {
			SingleProcess sp = new SingleProcess();
			list.add(es.submit(sp));
		}
		es.shutdown();
		
		for(Future<String> s: list) {
			
			try {
				System.out.println(s.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

class SingleProcess implements Callable<String> {
	
private static Long id = 0L;
	
	@Override
	public String call() throws Exception {
		try {
			System.out.println("Start");
			Thread.sleep(3000+((int)(Math.random()*1000)));
			System.out.println("Stop");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "STRING"+(id++);
	}
	
}
