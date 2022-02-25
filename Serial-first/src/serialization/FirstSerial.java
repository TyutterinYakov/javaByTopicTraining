package serialization;

import java.io.Serializable;

public class FirstSerial implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String lastName;
	
	
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
	
	public String toString() {
		return String.format(
				"id: %s firstName: %s lastName: %s",
				id, firstName, lastName);
	}
	
}
