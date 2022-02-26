
public class MyClass {

	
	private Long id;
	private String firstName;
	
	public MyClass(Long id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Override
	public int hashCode() {
		return id.intValue();
	}
	@Override
	public boolean equals(Object obj) {
		MyClass my = (MyClass)obj;
		return id.equals(my.getId())&&firstName.equals(my.firstName);
	}
	
	
	@Override
	public String toString() {
		return id+" "+firstName;
	}
	
	
}
