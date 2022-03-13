package flour.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import flour.service.MillService;

public class MillSocketHandler extends TextWebSocketHandler {

	private final Gson gson = new Gson();
	private final MillService millService;

	@Autowired
	public MillSocketHandler(MillService millService) {
		super();
		this.millService = millService;
	}

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage msg = new TextMessage(gson.toJson(millService.getState()));
        session.sendMessage(msg);
    }
	
	
	
	
}
