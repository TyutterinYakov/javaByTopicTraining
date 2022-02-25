package lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		File file = new File(".");
//		File[] files = file.listFiles(new MyFilter());
		
		
//		File[] files = file.listFiles(new FileFilter() {
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.isDirectory();
//			}
//			
//		});
//		
//		File[] files = file.listFiles((f)->f.isDirectory());
//		
//		for(File f : files) {
//			System.out.println(f.getName());
//		}
		

		List<String> strs = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			strs.add(String.format("%02d", i));
		}
		
		System.out.println(strs);
		
		
//		Collections.sort(strs, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});
//
		
		Collections.sort(strs, (o1, o2)->-o1.compareTo(o2));
		
		System.out.println(strs);
		
		
		
		
		
	}
}

class MyFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		return pathname.isDirectory();
	}
	
}
