package reactor.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;
import reactor.domain.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long>{

	Mono<User> findByUsername(String username);
}
