package flour.model;

import java.util.Queue;

import flour.model.engine.Engine;
import flour.model.engine.WaterWheel;
import flour.model.machine.Machine;
import flour.model.machine.MillStone;

public class Mill extends Thread {

	private final Machine machine;
	private final Engine engine;
	
	public Mill(Queue<Water> waterFlow, Queue<Millet> milletFlow, Queue<Flour> flourFlow) {
		this.engine = new WaterWheel(waterFlow);
		this.engine.start();
		this.machine = new MillStone(engine, milletFlow, flourFlow);
		this.machine.start();
	}
	
	public boolean isMachineOn() {
		return this.machine.isOn();
	}
	
	public boolean isEngineOn() {
		return this.engine.getPower() > 0;
	}
	
	public int getPower() {
		return this.engine.getPower();
	}

	@Override
	public void run() {
		while(!isInterrupted()){
			if(engine.getPower()>0) {
				machine.on();
			}
		}
	}
	
	
	
	
	
}
