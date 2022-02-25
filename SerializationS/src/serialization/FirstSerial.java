package serialization;

import java.io.Serializable;

public class FirstSerial {

	
//	private static final long serialVersionUID = 200L;
	private String id;
	private String firstName;
	private String lastName;
//	private transient Processor processor;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	public Processor getProcessor() {
//		return processor;
//	}
//	public void setProcessor(Processor processor) {
//		this.processor = processor;
//	}
	
	public String toString() {
		return String.format(
				"id: %s firstName: %s lastName: %s",
				id, firstName, lastName);
	}
	
}
