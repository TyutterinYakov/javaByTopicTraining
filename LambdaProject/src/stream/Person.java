package stream;

public class Person {

	
	private String firstName;
	private double grade;
	
	public Person(String firstName, double grade) {
		super();
		this.firstName = firstName;
		this.grade = grade;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	public String toString() {
		return String.format("firstName: %s grade: %s", firstName, grade);
	}
	
	
}
