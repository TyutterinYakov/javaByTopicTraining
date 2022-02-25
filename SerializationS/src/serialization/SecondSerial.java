package serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SecondSerial extends FirstSerial implements Externalizable {
	
	private String secondId;
	private String secondFirstName;
	private String secondLastName;
	public String getSecondId() {
		return secondId;
	}
	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}
	public String getSecondFirstName() {
		return secondFirstName;
	}
	public void setSecondFirstName(String secondFirstName) {
		this.secondFirstName = secondFirstName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	
	
	public String toString() {
		return String.format(
				"id: %s firstName: %s lastName: %s secondId: %s secondFirstName: %s secondLastName: %s",
				getId(), 
				getFirstName(), 
				getLastName(),
				secondId,
				secondFirstName,
				secondLastName);
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(getId());
		out.writeUTF(getFirstName());
		out.writeUTF(getLastName());
		out.writeUTF(secondId);
		out.writeUTF(secondFirstName);
		out.writeUTF(secondLastName);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setId(in.readUTF());
		setFirstName(in.readUTF());
		setLastName(in.readUTF());
		setSecondId(in.readUTF());
		setSecondFirstName(in.readUTF());
		setSecondLastName(in.readUTF());
	}

	
	
}
