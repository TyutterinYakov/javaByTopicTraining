package sort.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import sort.factory.SortServiceFactory;

@Configuration
@EnableWebSocket
@EnableScheduling
public class SocketConfiguration implements WebSocketConfigurer {

	private final StateSocketHandler stateSockethandler;
	
	public SocketConfiguration(SortServiceFactory sortServiceFactory) {
		this.stateSockethandler = new StateSocketHandler(sortServiceFactory);
	}

	@Scheduled(fixedRate = 10)
	private void sendStates() {
		stateSockethandler.sendState();
	}


	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(stateSockethandler, "/websocket").setAllowedOrigins("*");
	}

}
