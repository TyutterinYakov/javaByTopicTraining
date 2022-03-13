package flour.model;

import java.util.Queue;

public class MillState {
	
	private final int water;
	private final int millet;
	private final int flour;
	private final int power;
	private final boolean engine;
	private final boolean machine;
	
	public MillState(Mill mill, Queue<Water> waters, Queue<Millet> mallets, Queue<Flour> flours) {
		this.water = waters.size();
		this.millet = mallets.size();
		this.flour = flours.size();
		
		this.power = mill.getPower();
		this.engine = mill.isEngineOn();
		this.machine = mill.isMachineOn();
	}

	
	public int getWater() {
		return water;
	}

	public int getMillet() {
		return millet;
	}

	public int getFlour() {
		return flour;
	}

	public int getPower() {
		return power;
	}

	public boolean isEngine() {
		return engine;
	}

	public boolean isMachine() {
		return machine;
	}
	
	
	
	
	
	
}
