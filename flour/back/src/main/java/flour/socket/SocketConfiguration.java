package flour.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import flour.service.MillService;

@Configuration
@EnableWebSocket
public class SocketConfiguration implements WebSocketConfigurer {

	private final MillService millService;
	
	@Autowired
	public SocketConfiguration(MillService millService) {
		super();
		this.millService = millService;
	}
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(
				new MillSocketHandler(millService), "/websocket")
		.setAllowedOriginPatterns("*");
	}

}
