package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import cinema.model.Film;
import cinema.model.Hall;
import cinema.model.Ticket;
import cinema.service.ICinemaInitService;


@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	private ICinemaInitService cinemaService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	@Autowired
	public CinemaApplication(ICinemaInitService cinemaService) {
		super();
		this.cinemaService = cinemaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class, Hall.class, Ticket.class);
		cinemaService.initCities();
		cinemaService.initCinemas();
		cinemaService.initHalls();
		cinemaService.initPlaces();
		cinemaService.initSeances();
		cinemaService.initCategories();
		cinemaService.initFilms();
		cinemaService.initTicketViews();
		cinemaService.initTickets();
//		
	}

}
