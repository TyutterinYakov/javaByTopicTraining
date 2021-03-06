package multi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

import udp.QuoteServerThread;

public class MulticastServerThread extends QuoteServerThread {

	private Long FIVE_SECONDS = 5000L;
	
	public MulticastServerThread() throws IOException {
	}

	@Override
	public void run() {
		while(moreQuotes) {
			try {
				String dString;
				if(in==null) {
					dString = new Date().toString();
				} else {
					dString=getNextQuote();
				}
				
				byte[] buf = dString.getBytes();
				
				InetAddress group =InetAddress.getByName("225.0.0.1");
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
				socket.send(packet);
				System.out.println("Sent: "+dString);
				
				try {
					sleep((long)(Math.random()*FIVE_SECONDS));
				} catch(InterruptedException ex) {
					ex.printStackTrace(System.out);
				}
				
			} catch(IOException e) {
				e.printStackTrace(System.out);
				moreQuotes=false;
				
			}
		}
		socket.close();
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		new QuoteServerThread().start();
	}
	
	

}
