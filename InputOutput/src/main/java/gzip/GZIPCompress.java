package gzip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/Users/asatutterin/Desktop/simple2.txt"));
		BufferedOutputStream out = new BufferedOutputStream(
					new GZIPOutputStream(
							new FileOutputStream("/Users/asatutterin/Desktop/simple2.gz")));
		System.out.println("Запись файла");
		int c;
		while((c=in.read())!=-1) {
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("Чтение записи");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(
						new FileInputStream("/Users/asatutterin/Desktop/simple2.gz"))));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/asatutterin/Desktop/simple2.txt"));
		String s;
		while((s=br.readLine())!=null) {
			bos.write(s.getBytes());
		}
		br.close();
		bos.close();
	}
}
