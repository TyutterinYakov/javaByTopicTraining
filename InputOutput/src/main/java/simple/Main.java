package simple;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Main {
	
	
	public static void main(String[] args) {
		
	}
	
	public static void demoReadeWrite() {
		try(
				Reader r = new FileReader("/Users/asatutterin/Desktop/1111.rtf");
				Writer w = new FileWriter("/Users/asatutterin/Desktop/test/test.rtf", true);
			) {
				char[] buffer = new char[4096];
				int i = r.read(buffer);
				while(i!=-1) {
					w.write(buffer, 0, i);
					i=r.read(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void demoInputOutputStream() {
		try(
				InputStream is = new FileInputStream("/Users/asatutterin/Desktop/test.mkv");	
				OutputStream os = new FileOutputStream("/Users/asatutterin/Desktop/test/test.mkv", true);
			) {
	  			byte[] buffer = new byte[4096];
				int r = is.read(buffer);
				while(r!=-1) {
					os.write(buffer, 0, r);
					r = is.read(buffer);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void encodeDemo() {
		try(FileInputStream fis = new FileInputStream("/Users/asatutterin/Desktop/test/test.rtf");
				Reader r = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(r);
			) {
				String line = br.readLine();
				while(line!=null) {
					System.out.println(line);
					line = br.readLine();
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void demoMemory() {
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[10]);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	}
}
