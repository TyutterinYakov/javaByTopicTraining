package reactor.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.domain.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {

}
