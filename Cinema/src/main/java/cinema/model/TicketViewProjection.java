package cinema.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= {TicketView.class})
public interface TicketViewProjection {

	public Long getId();
	public double getPrice();
	public Date getDateTicket();
	public Hall getHall();
	public Film getFilm();
	public Seance getSeance();
	public List<Ticket> getTickets();
	
}
