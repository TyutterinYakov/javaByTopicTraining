package cinema.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.dao.CategoryRepository;
import cinema.dao.CinemaRepository;
import cinema.dao.CityRepository;
import cinema.dao.FilmRepository;
import cinema.dao.HallRepository;
import cinema.dao.PlaceRepository;
import cinema.dao.SeanceRepository;
import cinema.dao.TicketRepository;
import cinema.dao.TicketViewRepository;
import cinema.model.Category;
import cinema.model.Cinema;
import cinema.model.City;
import cinema.model.Film;
import cinema.model.Hall;
import cinema.model.Place;
import cinema.model.Seance;
import cinema.model.Ticket;
import cinema.model.TicketView;
import cinema.service.ICinemaInitService;

@Service
@Transactional
public class ICinemaInitServiceImpl implements ICinemaInitService {

	private CityRepository cityDao;
	private CinemaRepository cinemaDao;
	private HallRepository hallDao;
	private PlaceRepository placeDao;
	private SeanceRepository seanceDao;
	private TicketRepository ticketDao;
	private TicketViewRepository ticketViewDao;
	private FilmRepository filmDao;
	private CategoryRepository categoryDao;
	
	@Autowired
	public ICinemaInitServiceImpl(CityRepository cityDao, CinemaRepository cinemaDao, HallRepository hallDao,
			PlaceRepository placeDao, SeanceRepository seanceDao, TicketRepository ticketDao,
			TicketViewRepository ticketViewDao, FilmRepository filmDao, CategoryRepository categoryDao) {
		super();
		this.cityDao = cityDao;
		this.cinemaDao = cinemaDao;
		this.hallDao = hallDao;
		this.placeDao = placeDao;
		this.seanceDao = seanceDao;
		this.ticketDao = ticketDao;
		this.ticketViewDao = ticketViewDao;
		this.filmDao = filmDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public void initCities() {
		Stream.of("Санкт-Петербург", "Волхов", "Калининград", "Москва").forEach((c)->{
			City city = new City();
			city.setName(c);
			cityDao.save(city);
		});
	}

	@Override
	public void initCinemas() {
		cityDao.findAll().forEach((c)->{
			Stream.of("KonoStar", "FiveStars", "IMAX", "CinemaD")
				.forEach((nameCinema)->{
					Cinema cinema = new Cinema();
					cinema.setCity(c);
					cinema.setName(nameCinema);
					cinema.setNombreSalles(3+(int)Math.random()*7);
					cinemaDao.save(cinema);
					
				});
		});
	}

	@Override
	public void initHalls() {
		cinemaDao.findAll().forEach((c)->{
			for(int i=0; i<c.getNombreSalles(); i++) {
				Hall hall = new Hall();
				hall.setName("Hall "+(i+1));
				hall.setCinema(c);
				hall.setCountPlace(15+(int)(Math.random()*20));
				hallDao.save(hall);
			}
		});
	}

	@Override
	public void initPlaces() {
		hallDao.findAll().forEach((h)->{
			for(int i=0; i<h.getCountPlace(); i++) {
				Place place = new Place();
				place.setNumber(i+1);
				place.setHall(h);
				placeDao.save(place);
			}
		});
	}
	
	
	@Override
	public void initSeances() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Stream.of("12:00", "15:00", "17:00", "19:00", "21:00").forEach((t)->{
			Seance seance = new Seance();
			try {
				seance.setStartDate(format.parse(t));
				seanceDao.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initCategories() {
		Stream.of("History", "Comedy", "Drama", "Fantasy").forEach((n)->{
			Category category = new Category();
			category.setName(n);
			categoryDao.save(category);
		});
		
	}
	
	@Override
	public void initFilms() {
		double[] durations = new double[] {1, 1.5, 2, 2.5, 3};  
		List<Category> categories = categoryDao.findAll();
			Stream.of("Alisa", "Book diary", "Karlik nos", "Alkapone").forEach((f)->{
				Film film = new Film();
				film.setCategory(categories.get(new Random().nextInt(categories.size())));
				film.setTitle(f);
				film.setDuration(durations[new Random().nextInt(durations.length)]);
				film.setImage(f.replaceAll(" ", ""));
				filmDao.save(film);
			});
	}

	@Override
	public void initTicketViews() {
		double[] prices = new double[] {30, 50, 60, 80, 90, 100};
		List<Film> films = filmDao.findAll(); 
		cityDao.findAll().forEach(city->{
			city.getCinemas().forEach((cinema)->{
				cinema.getHalls().forEach(hall->{
					int index = new Random().nextInt(films.size());
					Film film = films.get(index);
						seanceDao.findAll().forEach((seance)->{
							TicketView ticketView = new TicketView();
							ticketView.setDateTicket(new Date());
							ticketView.setFilm(film);
							ticketView.setPrice(prices[new Random().nextInt(prices.length)]);
							ticketView.setHall(hall);
							ticketView.setSeance(seance);
							ticketViewDao.save(ticketView);
						});
				});
			});
		});
		
	}

//	@Override
//	public void initTickets() {
//		ticketViewDao.findAll().forEach((v)->{
//			v.getHall().getPlaces().forEach((p)->{
//				Ticket ticket = new Ticket();
//				ticket.setPlace(p);
//				ticket.setPrice(v.getPrice());
//				ticket.setTicketView(v);
//				ticket.setReserve(false);
//				ticketDao.save(ticket);
//				
//			});
//		});
//	}
    @Override
    public void initTickets() {
        ticketViewDao.findAll().forEach(projection -> {
            projection.getHall().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrice(projection.getPrice());
                ticket.setTicketView(projection);
                ticket.setReserve(false);
                ticketDao.save(ticket);
            });
        });
    }


}
