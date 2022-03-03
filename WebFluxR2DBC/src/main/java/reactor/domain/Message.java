package reactor.domain;

import org.springframework.data.annotation.Id;

public class Message {
	
	@Id
	private Integer id;
	private String data;

	public Message() {
		super();
	}

	public Message(String data) {
		super();
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	
}
