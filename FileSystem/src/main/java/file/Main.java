package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

	
	public static void main(String[] args) {
		File file = new File("/Users/asatutterin/eclipse-workspace/Exam/ExamPortal");
//		System.out.println("ExistsFile: "+file.exists());
//		System.out.println("CanRead: "+file.canRead());
//		System.out.println("CanWrite: "+file.canWrite());
//		System.out.println("Directory?: "+file.isDirectory());
//		System.out.println("File?: "+file.isFile());
		String[] files = file.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				
				return name.startsWith(".");
			}
		});
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i]);
		}
		
		Path p = Paths.get(".", "pom.xml");
		
		try {
			Stream<String> lines = Files.lines(p);
			lines.forEach((l)->{
				System.out.println(l);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
