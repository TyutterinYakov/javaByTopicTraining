package cinema.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TicketView {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateTicket;
	private double price;
	@ManyToOne
	private Hall hall;
	@ManyToOne
	private Film film;
	@JsonIgnore
	@OneToMany(mappedBy="ticketView")
	private List<Ticket> tikects;
	@ManyToOne
	private Seance seance;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateTicket() {
		return dateTicket;
	}
	public void setDateTicket(Date dateTicket) {
		this.dateTicket = dateTicket;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public List<Ticket> getTikects() {
		return tikects;
	}
	public void setTikects(List<Ticket> tikects) {
		this.tikects = tikects;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
	
	
	

}
