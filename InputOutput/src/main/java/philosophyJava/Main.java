package philosophyJava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringReader;

public class Main {

	private static final String repo="/Users/asatutterin/Desktop/";
	
	public static void main(String[] args) throws Exception {
		simpleRandomAccessFile();
	}
	
	//Чтение из файла
	public static String reader(String fileName) throws Exception {
		String file=repo+fileName;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s=br.readLine())!=null) {
			sb.append(s+"\n");
		}
		br.close();
		return sb.toString();
	}
	
	//Чтение из памяти
	public static void simpleStringReader() throws Exception{
		StringReader sr = new StringReader(reader("1111.txt"));
		int c;
		while((c=sr.read())!=-1) {
			System.out.print((char)c);
		}
		
	}
	
	//Чтение форматированных данных
	public static void formatingDataInputStream() throws Exception{
//		try {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(reader("1111.txt").getBytes()));
		while(dis.available()!=0) {
			System.out.print((char)dis.readByte());
		}
//		} catch(EOFException ex) {
//			System.err.println("File end");
//		}
		
	}
	
	//Запись в файл
	public static void simpleFileWriter() throws Exception {
		BufferedReader br = new BufferedReader(
				new StringReader(reader("1111.txt")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(repo+"simple.txt")));
		int lineCount=1;
		String s;
		while((s=br.readLine())!=null) {
			pw.println((lineCount++)+": "+s);
		}
		pw.close();
		br.close();
		System.out.println(reader("simple.txt"));
	}
	
	//Сохращенная запись в файл
	public static void demoFileWriter() throws Exception {
		BufferedReader br = new BufferedReader(new StringReader(reader("1111.txt")));
		PrintWriter pw = new PrintWriter(repo+"simple2.txt");
		int lineCount=0;
		String s;
		while((s=br.readLine())!=null) {
			pw.println(++lineCount+": "+s);
		}
		br.close();
		pw.close();
		System.out.println(reader("simple2.txt"));
	}
	
	public static void inputOutputStreamSimple() throws Exception {
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(repo+"demo.txt")));
//		dos.write(3333);
		dos.writeUTF("Hello my friends");
		dos.writeDouble(3.14);
		dos.close();
		
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(new FileInputStream(repo+"demo.txt")));
		System.out.println(dis.readUTF());
		System.out.println("-------------");
		System.out.println(dis.readDouble());
		System.out.println("-------------");
		dis.close();
		
	}
	
	public static void simpleRandomAccessFile() throws Exception{
		RandomAccessFile raf = new RandomAccessFile(repo+"demo.txt", "r"); //r - чтение  rw-запись и чтение
		System.out.println(raf.readUTF());
		System.out.println(raf.readDouble());
		raf.close();
	}
}
