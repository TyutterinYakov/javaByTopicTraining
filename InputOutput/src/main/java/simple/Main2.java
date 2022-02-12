package simple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main2 {

	public static final int BSIZE=1024;
	public static final String file = "/Users/asatutterin/Desktop/simple.txt";
	
	public static void main(String[] args) throws Exception{
		simpleNIO();
	}
	
	public static void printWriter() {
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("Hello world");
		
	}
	
	
	public static void simpleNIO() throws Exception{
		//Запись файла
		FileChannel fc = new FileOutputStream(file).getChannel();
		fc.write(ByteBuffer.wrap("Hello world".getBytes()));
		fc.close();
		//Запись в конец файла
		fc = new RandomAccessFile(file, "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("HeLLO TWO".getBytes()));
		fc.close();
		//Чтение файла
		fc=new FileInputStream(file).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fc.read(buffer);
		buffer.flip();
		while(buffer.hasRemaining()) {
			System.out.print((char)buffer.get());
		}
		
	}
}
