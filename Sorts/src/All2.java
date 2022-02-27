
public class All2 {

	
	public static void main(String[] args) {
		
		int[] arr = {4,8,4,-8,3,4,2,1,8,0,5,5,5,3,2,4,-1,3,2,0,5,-9,7,4,43,3,4,43,4,34,4,343,4,34,4,4,34,43,34,34,34,43,4,43,2,3,1,23453,647,856,463,42,5367,456352,3453,67,45634523,4};
		
		sortArray(0, arr);
	}
	
	
	
	private static void sortArray(int sort, int[] arr) {
		
		int[] arr2 = new int[arr.length]; 
		
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int min=arr[j];
					int other = arr[i];
					arr[i]=min;
					arr[j]=other;
				}
			}
			
		}
		
		
		for(int i: arr) {
			System.out.print(i+" ");
		}
		
	}
}
