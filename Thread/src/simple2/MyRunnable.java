package simple2;import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Start runnable"+Thread.currentThread().getId());
		try {
			Thread.sleep(5000);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Stop runnable"+Thread.currentThread().getId());
	}

	
}
