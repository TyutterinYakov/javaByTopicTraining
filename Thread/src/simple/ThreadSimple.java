package simple;

import java.math.BigInteger;
import java.security.SecureRandom;

public class ThreadSimple {

	public static final int TASK_COUNT = 500000;
	
	public static void main(String[] args) {
		Long summa = 0L;
		
		System.out.println("Начало:"+System.currentTimeMillis());
		for(int i=0; i<10; i++) {
			SingleProcess sp = new SingleProcess();
			sp.start();
		}
		System.out.println(summa);
		System.out.println("Конец: "+System.currentTimeMillis());
		
	}
}

class SingleProcess extends Thread {
	
	@Override
	public void run() {
		process();
	}

	public Long process() {
		Long summa = 0L;
		
		SecureRandom random = new SecureRandom();
		
		for(int i=0; i<ThreadSimple.TASK_COUNT; i++) {
			String g=new BigInteger(500, random).toString(32);
			for(char c: g.toCharArray()) {
				summa+=c;
			}
		}
		System.out.println(summa);
		return summa;
	}
	
}
