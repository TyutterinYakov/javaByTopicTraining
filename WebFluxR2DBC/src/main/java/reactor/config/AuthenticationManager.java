package reactor.config;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager{

	private final JwtUtil jwtUtil;
	
	@Autowired
	public AuthenticationManager(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}



	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		String token = authentication.getCredentials().toString();
		String username;
		
		try {
			username = jwtUtil.extractUsername(token);
		} catch(Exception ex) {
			username=null;
			ex.printStackTrace();
		}
		
		if(username!=null&&jwtUtil.validateToken(token)) {
			Claims claimsFromToken = jwtUtil.getClaimsFromToken(token);
			List<String> role = claimsFromToken.get("role", List.class);
			List<SimpleGrantedAuthority> simple = 
					role.stream()
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			
			UsernamePasswordAuthenticationToken authToken = 
					new UsernamePasswordAuthenticationToken(username, null, simple);
			
			
			return Mono.just(authToken); 
		} else {
			return Mono.empty();
		}
		
	}

}
