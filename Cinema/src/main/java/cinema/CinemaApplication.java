package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cinema.service.ICinemaInitService;


@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	private ICinemaInitService cinemaService;
	
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
//		cinemaService.initCities();
//		cinemaService.initCinemas();
//		cinemaService.initHalls();
//		cinemaService.initPlaces();
//		cinemaService.initSeances();
//		cinemaService.initCategories();
//		cinemaService.initFilms();
//		cinemaService.initTicketViews();
//		cinemaService.initTickets();
//		
	}

}
