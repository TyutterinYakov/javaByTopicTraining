package channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
	
	public static void main(String[] args) {
		transferDemo();
	}
	
	
	public static void demoChannel() {
		try(
				FileInputStream fis = new FileInputStream("/Users/asatutterin/Desktop/test.mkv");
				FileOutputStream fos = new FileOutputStream("test.mkv");
				FileChannel inChannel = fis.getChannel();
				FileChannel outChannel = fos.getChannel();
		) {
			ByteBuffer inBb = ByteBuffer.allocate(4096); 
			ByteBuffer outBb = ByteBuffer.allocate(4096); 
			int r = inChannel.read(inBb); //Перевод в режим записи
			while(r!=-1) {
				inBb.flip(); //Перевод в режим чтения/Перемещение позиции в буфере в начало
				while(inBb.hasRemaining()) {
					byte get = inBb.get();
					outBb.put(get);
				}
				outBb.flip();
				outChannel.write(outBb);
				inBb.clear();
				outBb.clear();
				r = inChannel.read(inBb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void transferDemo() {
		
		try(
			FileInputStream fis = new FileInputStream("/Users/asatutterin/Desktop/test.mkv");
				FileOutputStream fos = new FileOutputStream("test.mkv");
				FileChannel inChannel = fis.getChannel();
				FileChannel outChannel = fos.getChannel();
			){
//				inChannel.transferTo(0, inChannel.size(), outChannel);
				outChannel.transferFrom(inChannel, 0, inChannel.size());
			
			
			} catch(Exception ex) {
			
				
				
			}
	}
}
