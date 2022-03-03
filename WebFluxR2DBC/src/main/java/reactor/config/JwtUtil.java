package reactor.config;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.domain.User;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private String expiration;
	
	public String extractUsername(String token) {
		return getClaimsFromToken(token).getSubject();
		
	}


	public boolean validateToken(String token) {
		return getClaimsFromToken(token)
				.getExpiration()
				.before(new Date());
		
	}
	
	
	public Claims getClaimsFromToken(String token) {
		String key = Base64.getEncoder().encodeToString(secret.getBytes());
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("role", List.of(user.getRole()));
		Long expirationSeconds = Long.parseLong(expiration);
		Date creationDate = new Date();
		Date expirationDate = new Date(creationDate.getTime()+expirationSeconds*1000);
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(user.getUsername())
				.setIssuedAt(creationDate)
				.setExpiration(expirationDate)
				.signWith(Keys.hmacShaKeyFor(secret.getBytes()))
				.compact();
				
	}

}
