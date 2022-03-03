package reactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.repository.UserRepository;

@Service
public class UserService implements ReactiveUserDetailsService{

	
	private final UserRepository userDao;

	
	
	
	@Autowired
	public UserService(UserRepository userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public Mono<UserDetails> findByUsername(String username) {
		
		return userDao.findByUsername(username)
				.cast(UserDetails.class);
	}
}
