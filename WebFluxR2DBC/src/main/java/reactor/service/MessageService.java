package reactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.domain.Message;
import reactor.repository.MessageRepository;

@Service
public class MessageService {

	private final MessageRepository messageDao;

	@Autowired
	public MessageService(MessageRepository messageDao) {
		super();
		this.messageDao = messageDao;
	}
	
	
	public Flux<Message> listMessage(){
		return messageDao.findAll();
	}
	
	
	public Mono<Message> saveOne(Message message){
		return messageDao.save(message);
	}
	
	
}
