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
public class Cinema {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cinemaId;
	private String name;
	private double longitube, latitube, altitube;
	private int nombreSalles;
	@OneToMany(mappedBy="cinema")
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Hall> halls;
	@ManyToOne
	private City city;
	
	
	public Long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongitube() {
		return longitube;
	}
	public void setLongitube(double longitube) {
		this.longitube = longitube;
	}
	public double getLatitube() {
		return latitube;
	}
	public void setLatitube(double latitube) {
		this.latitube = latitube;
	}
	public double getAltitube() {
		return altitube;
	}
	public void setAltitube(double altitube) {
		this.altitube = altitube;
	}
	public int getNombreSalles() {
		return nombreSalles;
	}
	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}
	public List<Hall> getHalls() {
		return halls;
	}
	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
	
	
}
