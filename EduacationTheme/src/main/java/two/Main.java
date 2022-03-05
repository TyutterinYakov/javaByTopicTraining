package two;

import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		System.out.println(countOne(20, 22, 20));
		
		
	}
	



	private static int countOne(int x, int y, int z) {
		int max = Math.max(x, y);
		int min = Math.min(x, y);
		int count = 0;
		while(true) {
			if(max>=z&&(max-min)>=2) {
				break;
			}
			max++;
			count++;
		}
		return count;
	}
	
	
}
