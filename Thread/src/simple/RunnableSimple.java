package simple;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RunnableSimple {

	public static final int TASK_COUNT = 500000;
	
	public static void main(String[] args) throws InterruptedException {
		Long summa = 0L;
		
		System.out.println("Начало:"+System.currentTimeMillis());
		List<SingleProcesss> processes = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SingleProcesss sp = new SingleProcesss("ID: "+i+" Summa: ");
			Thread t = new Thread(sp);
			t.start();
			processes.add(sp);
		}
		
		Thread.sleep(40000);
		for(SingleProcesss sp: processes) {
			System.out.println(sp.getSumma());
		}
		
	}
}

class SingleProcesss implements Runnable {
	
	private String name;
	private Long summa;
	
	public SingleProcesss(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		summa = process();
	}

	public Long process() {
		Long summa = 0L;
		
		SecureRandom random = new SecureRandom();
		
		for(int i=0; i<RunnableSimple.TASK_COUNT; i++) {
			String g=new BigInteger(500, random).toString(32);
			for(char c: g.toCharArray()) {
				summa+=c;
			}
		}
		System.out.println(name+summa);
		System.out.println("Конец: "+System.currentTimeMillis());
		return summa;
	}

	public Long getSumma() {
		return summa;
	}
	
	
}

