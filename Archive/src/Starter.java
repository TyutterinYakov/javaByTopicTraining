import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Starter {

	public static void main(String[] args) throws Exception {
//		readZip();
		
//		writerZip();
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("file.zip"));
		File[] files = new File(".").listFiles();
		
		createZipDir(zos, files, "");
		zos.close();
	}

	private static void readZip() throws Exception {
		
		ZipFile zip = new ZipFile("/Users/asatutterin/Desktop/SpringAdmin.zip");
		
//		for(Enumeration<? extends ZipEntry> iter = zip.entries(); iter.hasMoreElements();) {
//			ZipEntry ze = iter.nextElement();
//			System.out.println(String.format("Entry: %s",ze.getName())+"----------------------->>>>");
//			if(!ze.isDirectory()) {
//				BufferedReader br = new BufferedReader(
//						new InputStreamReader(zip.getInputStream(ze)));
//				String line=null;
//				while((line=br.readLine())!=null) {
//					System.out.println(line);
//				}
//				
//			}
//			System.out.println("----------------------------------->>>>");
//		}
		
		
		zip.stream().forEach(new MyZip(zip));
	}
	
	private static void writerZip() throws Exception {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("test.zip"));
		
		ZipEntry ze = new ZipEntry("name1.txt");
		zos.putNextEntry(ze);
		zos.write("SUPER1".getBytes());
		
		ZipEntry ze2 = new ZipEntry("name2.txt");
		zos.putNextEntry(ze2);
		zos.write("SUPER2".getBytes());
		
		zos.close();
		
	}

	private static void createZipDir(ZipOutputStream zos, File[] files, String path) throws Exception {
		
		for(File f: files){
			if(f.isDirectory()) {
				createZipDir(zos, f.listFiles(), path+f.getName()+File.pathSeparator);
			} else if(!f.getName().equals("file.zip")) {
				ZipEntry ze = new ZipEntry(path+f.getName());
				zos.putNextEntry(ze);
				
				FileInputStream fis = new FileInputStream(f);
				byte[] buffer = new byte[1024];
				int size = -1;
				while((size=fis.read())!=-1) {
					zos.write(buffer, 0, size);
				}
				fis.close();
			}
		}
		
	}
	
	
	
}







class MyZip implements Consumer<ZipEntry> {
	
	
	private ZipFile zipFile;
	
	public MyZip(ZipFile zipFile) {
		super();
		this.zipFile = zipFile;
	}


	@Override
	public void accept(ZipEntry ze) {
		System.out.println(String.format("Entry: %s",ze.getName())+"----------------------->>>>");
		if(!ze.isDirectory()) {
			BufferedReader br;
			try {
				br = new BufferedReader(
						new InputStreamReader(zipFile.getInputStream(ze)));
				String line=null;
				while((line=br.readLine())!=null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		System.out.println("----------------------------------->>>>");
		
	}
	
}
