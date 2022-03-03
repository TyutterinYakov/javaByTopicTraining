package reactor.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import reactor.config.JwtUtil;
import reactor.core.publisher.Mono;
import reactor.domain.User;
import reactor.service.UserService;

@RestController
public class UserController {

	private final UserService userService;
	private final JwtUtil jwtUtil;
	private static final ResponseEntity<Object> UNAUTHORIZED = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
	
	@Autowired
	public UserController(UserService userService, JwtUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}


	@PostMapping("/login")
	public Mono<ResponseEntity> login(ServerWebExchange swe){
		
		System.out.println(swe.getFormData());
		
		System.out.println(swe.getRequest().getBody().collectSortedList().toString());
		
		
		return swe.getFormData().flatMap(credentials->
			userService.findByUsername(credentials.getFirst("username"))
			.cast(User.class)
			.map(userDetails->
				Objects.equals(
						credentials.getFirst("password"), 
						userDetails.getPassword()
						)
							? ResponseEntity.ok(jwtUtil.generateToken(userDetails))
							:UNAUTHORIZED
			)
			.defaultIfEmpty(UNAUTHORIZED)
		);
	}
	
	
}
