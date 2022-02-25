package instance;


public class First {

	private String name;

	
	
	public First() {
//		throw new RuntimeException();
		System.out.println("Hello");
		}

	private First(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
