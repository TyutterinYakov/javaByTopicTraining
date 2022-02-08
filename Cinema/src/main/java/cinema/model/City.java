package cinema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cityId;
	private String name;
	private double longitude, latidude, altitube;
	@OneToMany(mappedBy="city")
	@JsonIgnore
	private List<Cinema> cinemas;
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatidude() {
		return latidude;
	}
	public void setLatidude(double latidude) {
		this.latidude = latidude;
	}
	public double getAltitube() {
		return altitube;
	}
	public void setAltitube(double altitube) {
		this.altitube = altitube;
	}
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	
	
}
