import java.util.ArrayList;
import java.util.List;

public class Main {

	
	
	public static void main(String[] args) {
		
		int[] arr = {4,8,4,8,3,4,2,1,8,0,5,5,5,3,2,4,-1,3,2,0,5,-9,7,4};
		
		
		sortArray(arr);
		minElementArray(arr);
		maxElementArray(arr);
		cicleOneElements();
		cicleOneElementsTwo();
		reverseString("Tyutterin");
		cicleManyElements();
		fibonachi(50);
		palindrom();
		
	}

	private static void sortArray(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int min = arr[j];
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
	
	
	
	private static void minElementArray(int[] arr) {
		
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		
		System.out.println("\nMin: "+min);
	}
	
	private static void maxElementArray(int[] arr) {
		
		int max=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		System.out.println("\nMax: "+max);
		
	}
	
	
	private static void cicleOneElements() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,9,17,18,19,20};
		
		int cicle=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i]==arr[j]&&i!=j) {
					cicle=arr[i];
					break;
				}
			}
			
			
		}
		
		System.out.println("Повторяющийся элемент: "+cicle);
	}
	
	
	
	private static void cicleOneElementsTwo() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,9,17,18,19,20};
		
		int summ=0;
		for(int i=1; i<21; i++) {
			summ+=i;
		}
		System.out.println("Сумма элементов от 1 до 21: "+summ);
		
		int summTwo=0;
		for(int i=0; i<arr.length; i++) {
			summTwo+=arr[i];
		}
		
		System.out.println("Сумма элементов в массиве  arr: "+summTwo);
		
		
		System.out.println("Повторяющийся элемент: "+(summTwo-summ));
		
	}
	
	
	private static void cicleManyElements() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,11,14,3,15,16,9,17,18,19,20};
		
		List<Integer> dubles = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					dubles.add(arr[i]);
				}
				
				
			}
		}
		System.out.println("Повторы: "+dubles);
		
	}
	
	
	
	private static void reverseString(String str) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		
		System.out.println(sb.toString());
	}
	
	
	private static void fibonachi(int number) {
		long fib1=1;
		long fib2=1;
		long fib3=0;
		for(int i=0; i<=number; i++) {
			System.out.print(fib1+" ");
			fib3=fib1+fib2;
			fib1=fib2;
			fib2=fib3;
		}
		
	}
	
	
	private static void palindrom() {
		String str = "qwertytrewq";
		
		System.out.println();
		int lengthStr = str.length();
		int count=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==str.charAt(--lengthStr)) {
				count++;
				if(count==str.length()) {
					System.out.println("It's okey");
				}
			} else {
				System.out.println("NO");
				break;
			}
			
		}
		
	}
}
