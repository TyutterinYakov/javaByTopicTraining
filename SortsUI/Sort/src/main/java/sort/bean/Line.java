package sort.bean;

public class Line {

	private int value;

	public Line(int value) {
		super();
		this.value = value;
	}

	public Line() {
		super();
	}

	public int getValue() {
		return value;
	}

	public boolean compare(Line other) {
		return this.getValue()>other.getValue();
	}
	
	
}
