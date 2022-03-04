package Basic;

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {1,4,1,5,9,3,1,6,9,4,2,1,0,9,87,3,32,21,12};
		//Максимальное
		System.out.println(max(arr));
		//Минимальное
		System.out.println(min(arr));
		//Среднее
		System.out.println(average(arr));
		
		
		
	}


	private static double average(int[] arr) {
		int summ=0;
		for(int i=0; i<arr.length; i++) {
			summ+=arr[i];
		}
		return summ/arr.length;
	}

	private static int min(int[] arr) {
		int m=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(m>arr[i]) {
				m=arr[i];
			}
		}
		return m;
	}

	private static int max(int[] arr) {
		int m=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(m<arr[i]) {
				m=arr[i];
			}
		}
		return m;
	}
	
	
	
	
	
	
	
	
}
