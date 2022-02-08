package cinema.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.dao.FilmRepository;
import cinema.dao.TicketRepository;
import cinema.model.Film;
import cinema.model.Ticket;
import cinema.model.TicketForm;

@RestController
public class CinemaRestController {

	private FilmRepository filmDao;
	private TicketRepository ticketDao;
	
	@Autowired
	public CinemaRestController(FilmRepository filmDao, TicketRepository ticketDao) {
		super();
		this.filmDao = filmDao;
		this.ticketDao = ticketDao;
	}

	@GetMapping(path="/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@Transactional
	public byte[] image(@PathVariable("id") Long filmId) throws IOException {
		Optional<Film> film = filmDao.findById(filmId);
		if(film.isPresent()) {
			String photoName = film.get().getImage();
			File file = new File("/Users/asatutterin/eclipse-workspace/Cinema/src/main/resources/static/images/"
					+photoName+".jpeg");
			Path path = Paths.get(file.toURI());
			return Files.readAllBytes(path);
		}
		return null;
	}
	

	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> ticketPayer(@RequestBody TicketForm ticketForm) {
		List<Ticket> tickets = new ArrayList<>();
		ticketForm.getTickets().forEach((t)->{
			Ticket ticket = ticketDao.findById(t).get();
			ticket.setNumClient(ticketForm.getNumClient());
			ticket.setReserve(true);
			tickets.add(ticketDao.save(ticket));
		});
		return tickets;
	}

}
