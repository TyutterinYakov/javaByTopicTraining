package serializ;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

	private Long id;
	private String userName;
	private transient String password;
	private LocalDate dateOfBirth;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "userId: "+id+" userName: "+userName+" password: "+password+" dateOfBirth: "+dateOfBirth;
	}
	
	
}
