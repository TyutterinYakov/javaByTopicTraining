package cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ticketId;
	private String numClient;
	private double price;
	@Column(unique=false, nullable=true)
	private Integer codePayment;
	private boolean reserve;
	@ManyToOne
	private Place place;
	@ManyToOne
	private TicketView ticketView;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getNumClient() {
		return numClient;
	}
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCodePayment() {
		return codePayment;
	}
	public void setCodePayment(int codePayment) {
		this.codePayment = codePayment;
	}
	public boolean isReserve() {
		return reserve;
	}
	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public TicketView getTicketView() {
		return ticketView;
	}
	public void setTicketView(TicketView ticketView) {
		this.ticketView = ticketView;
	}
	
	
	
}
