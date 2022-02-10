package cinema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long placeId;
	private int number;
	private double longitube, latidude, altitude;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	private Hall hall;
//	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@OneToMany(mappedBy="place")
	private List<Ticket> tickets;
	
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getLongitube() {
		return longitube;
	}
	public void setLongitube(double longitube) {
		this.longitube = longitube;
	}
	public double getLatidude() {
		return latidude;
	}
	public void setLatidude(double latidude) {
		this.latidude = latidude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
