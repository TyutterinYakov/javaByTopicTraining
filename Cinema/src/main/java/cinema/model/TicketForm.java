package cinema.model;

import java.util.ArrayList;
import java.util.List;

public class TicketForm {

	private String numClient;
	
	private List<Long> tickets = new ArrayList<>();
	public String getNumClient() {
		return numClient;
	}
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	public List<Long> getTickets() {
		return tickets;
	}
	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}
	
	
}
