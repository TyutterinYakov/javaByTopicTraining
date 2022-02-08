package udp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class QuoteServerThread extends Thread {

	protected DatagramSocket socket;
	protected BufferedReader in;
	protected boolean moreQuotes=true;
	
	public QuoteServerThread() throws IOException{
		socket = new DatagramSocket(4445);
		try {
			in = new BufferedReader(new FileReader("/Users/asatutterin/eclipse-workspace/UDPExample/src/main/java/udp/one-liners.txt"));
		} catch(FileNotFoundException ex) {
			System.err.println("Could not open quote file. Serving time instead.");
		}
	}

	@Override
	public void run() {
		while(moreQuotes){
			try {
				byte[] buffer = new byte[256];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				
				String dString;
				if(in==null) {
					dString  = new Date().toString();
				} else {
					dString = getNextQuote();
				}
				
				buffer=dString.getBytes();
				
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				System.out.println("Port: "+port);
				packet = new DatagramPacket(buffer, buffer.length, address, port);
				socket.send(packet);
			} catch(IOException ex) {
				ex.printStackTrace();
				moreQuotes=false;
			}
		}
	}
	
	protected String getNextQuote() {
		String returnValue = null;
		try {
			if((returnValue=in.readLine())==null) {
				in.close();
				moreQuotes = false;
				returnValue = "No more Quotes! GoodBye";
			}
		} catch(IOException ex) {
			returnValue="IOException occured in server.";
		}
		return returnValue;
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		new QuoteServerThread().start();
	}
	
}
