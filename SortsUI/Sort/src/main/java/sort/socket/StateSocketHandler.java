package sort.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import sort.bean.SortLog;
import sort.bean.SortType;
import sort.factory.SortServiceFactory;
import sort.socket.bean.IncomeMessage;

public class StateSocketHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(StateSocketHandler.class);
	
	private final Gson gson = new Gson(); 
	private final SortServiceFactory sortServiceFactory;
	private final Map<WebSocketSession, SortType> states = new ConcurrentHashMap<>();
	
	@Autowired
	public StateSocketHandler(SortServiceFactory sortServiceFactory) {
		super();
		this.sortServiceFactory = sortServiceFactory;
	}
	
	public void sendState() {
		states.forEach((session, sortType)->{
			try {
			SortLog log = sortServiceFactory.get(sortType).pollLog(sortType.name());
			TextMessage msg = new TextMessage(gson.toJson(log));
				session.sendMessage(msg);
			} catch (IOException e) {
				logger.error(e.getMessage());
				states.remove(session);
			} catch(NullPointerException ex){
				logger.info("Sort {}, Queue is empty."+ex.getMessage(), sortType);
			}
		});
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		IncomeMessage income = gson.fromJson(message.getPayload(), IncomeMessage.class);
		SortType sortType = income.getSortType();
		String target = sortType.name();
		if(income.isPlay()) {
			states.put(session, sortType);
			sortServiceFactory.get(sortType).sort(target);
		}
		if(income.isStop()) {
			states.remove(session);
			sortServiceFactory.get(sortType).sort(target);
		}
	}


}
