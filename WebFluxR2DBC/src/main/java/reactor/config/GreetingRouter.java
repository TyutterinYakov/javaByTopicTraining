package reactor.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.handlers.GreetingHandler;


@Configuration
public class GreetingRouter {

	
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler handler){
		RequestPredicate route = RequestPredicates
				.GET("/hello")
					.and(RequestPredicates.accept(
							MediaType.APPLICATION_JSON));
		
		return RouterFunctions
				.route(route, handler::hello)
				.andRoute(
						RequestPredicates
						.GET("/"),
						handler::home
						
				);
	}
}
