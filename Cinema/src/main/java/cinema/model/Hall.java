package cinema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Hall {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hollId;
	private String name;
	private int countPlace;
	@ManyToOne
	private Cinema cinema;
	@OneToMany(mappedBy="hall")
	@JsonIgnore
	private List<Place> places;
	@JsonIgnore
	@OneToMany(mappedBy="hall")
	private List<TicketView> ticketViews;
	
	
	public Long getHollId() {
		return hollId;
	}
	public void setHollId(Long hollId) {
		this.hollId = hollId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountPlace() {
		return countPlace;
	}
	public void setCountPlace(int countPlace) {
		this.countPlace = countPlace;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public List<TicketView> getTicketViews() {
		return ticketViews;
	}
	public void setTicketViews(List<TicketView> ticketViews) {
		this.ticketViews = ticketViews;
	}
	
	
}
