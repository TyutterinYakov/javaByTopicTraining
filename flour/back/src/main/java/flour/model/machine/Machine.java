package flour.model.machine;

public class Machine extends Thread {

	private boolean on = false;

	public boolean isOn() {
		return on;
	}
	
	public void on() {
		on = true;
	}
	
	public void off() {
		on = false;
	}
}
