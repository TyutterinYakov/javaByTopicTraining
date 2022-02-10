package cinema.model;


import org.springframework.data.rest.core.config.Projection;


@Projection(name="ticketsProjection", types=Ticket.class)
public interface TicketProjection {

	public Long getTicketId();
	public String getNumClient();
	public double getPrice();
	public String getCodePayment();
	public boolean getReserve();
	public Place getPlace();
}
