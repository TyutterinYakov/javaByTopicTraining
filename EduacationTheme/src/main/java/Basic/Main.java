package Basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {1,4,1,5,9,3,1,6,9,4,2,1,0,9,-87,3,32,21,12};
		int arr2[] = {1,1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1};
		int arr3[] = {1,1,2,1,1,5,6,5,2,2,6,7,9,7,9};
		//Максимальное
		System.out.println(max(arr));
		//Минимальное
		System.out.println(min(arr));
		//Среднее
		System.out.println(average(arr));
		//Сортировка
		sort(arr);
		//Миниальное
		System.out.println("\n"+minSort(arr));
		//Максимальное
		System.out.println(maxSort(arr));
		//Сортировка чисел внутри числа
		System.out.println(sortNumber(898253679));
		System.out.println();
		//Сумма горизонтальных линий в треугольнике
		System.out.println(summTrinagle(3));
		//Проверка на существование треугольника
		System.out.println(checkTrinagle(3,11,12));
		//Поиск значения которое не повторяется
		System.out.println(searchOneNumber(arr2));
		//Удаление гласных
		System.out.println(removeVowels("Hello my dier friend! You lol check"));
		//Удаление гласных
		System.out.println(disemvowel("Hello my dier friend! You lol check"));
		//Поиск числа, которое находится в массиве нечетное количество раз
		System.out.println(searchNumber(arr3));
		System.out.println(findIt(arr3));
		
	}



	private static void sort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++){
				if(arr[i]<arr[j]) {
					int other = arr[i];
					arr[i]=arr[j];
					arr[j]=other;
				}
			}
		}
		
		for(int i: arr) {
			System.out.print(i+", ");
		}
		
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
	
	
	private static int minSort(int[] arr) {
		Arrays.sort(arr);
		return arr[0];
	}
	
	private static int maxSort(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length-1];
	}
	
	private static Integer sortNumber(Integer num) {
		String[] nums = num.toString().split("");
		Arrays.sort(nums);
		return Integer.valueOf(
				Arrays.stream(nums).collect(Collectors.joining()));
	}
	
	
	private static double summTrinagle(int line) {
		return (int)Math.pow(line, 3);
	}
	
	
	private static boolean checkTrinagle(int a1, int a2, int a3) {
		int max = Math.max(Math.max(a2, a3), a1);
		if(a1+a2+a3-max<=max) {
			return false;
		}
		return true;
	}
	
	private static int searchOneNumber(int[] arr) {
		Arrays.sort(arr);
		if(arr[0]!=arr[1]) {
			return arr[0];
		} else {
			return arr[arr.length-1];
		}
	}
	
	private static String removeVowels(String str) {
		List<String> strs = Arrays.asList(str.split(""));
		String[] regex= {"e", "u", "i", "o", "a"};
		for(String r: regex) {
			strs = strs.stream()
					.filter((s)->!s.equalsIgnoreCase(r)).collect(Collectors.toList());
		}
		return strs.stream().collect(Collectors.joining());
	}
	
    public static String disemvowel(String Z) {
        return Z.replaceAll("(?i)[aeiou]" , "");
    }
	
    
	private static int searchNumber(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			int count =0;
			for(int j=0; j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					++count;
				}
				if(count%2!=0&&arr.length==j+1) {
					return arr[i];
				}
			}
		}
		return 0;
	}
	
	public static int findIt(int[] A) {
		int xor = 0;
	    for (int i = 0; i < A.length; i++) {
	      xor ^= A[i];
	    }
	    return xor;
	}
	
	public static int autobus(List<int[]> list) {
		int count=0;
		for(int i=0; i<list.size(); i++) {
			count=count+(list.get(i)[0])-list.get(i)[1];
		}
		return count;
	}
	
	public static int autobusTwo(List<int[]> list) {
		
		return list.stream().mapToInt(s-> s[0]-s[1]).sum();
		
	}
	
	
	
	
	
	
	
}
