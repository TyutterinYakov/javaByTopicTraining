package reactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.domain.Message;
import reactor.service.MessageService;

@RestController
@RequestMapping("/controller")
public class MainController {

	
	private final MessageService messageService;
	
	@Autowired
	public MainController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}


	@GetMapping
	public Flux<Message> getMessage(
			@RequestParam(name="start", defaultValue = "0") Long start,
			@RequestParam(name="count", defaultValue = "3") Long count){
		return messageService.listMessage();
	}
	
	
	@PostMapping
	public Mono<Message> saveMessage(@RequestBody Message message) {
		return messageService.saveOne(message);
	}
	
	
}
