import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSimple {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> submit =  es.submit(new SingleProcess());
		boolean done = submit.isDone();
		System.out.println(done);
		try {
			Thread.sleep(4000);
			String get = submit.get();
			System.out.println(get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		es.shutdown();
	}
}


class SingleProcess implements Callable<String> {
	
private String name = null;
	
	@Override
	public String call() throws Exception {
		try {
			System.out.println("Start");
			Thread.sleep(3000);
			System.out.println("Stop");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "STRING";
	}
	
}

//class SingleProcess implements Runnable{
//	
//private String name = null;
//	
//	@Override
//	public void run() {
//		try {
//			Thread.sleep(1000);
//			System.out.println(name.length());
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
////		System.out.println(name.length());
//	}
//	
//}
