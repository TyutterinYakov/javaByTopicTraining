package stream.model;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private Long id;
	private int parent; 
	private String name;
	
	
	
	public Department(Long id, int parent, String name) {
		super();
		this.id = id;
		this.parent = parent;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return this.name +" "+this.parent+" "+this.id;
	}
	
	
	
}
