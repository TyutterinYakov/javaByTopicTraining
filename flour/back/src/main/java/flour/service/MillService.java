package flour.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import flour.model.Flour;
import flour.model.Mill;
import flour.model.MillState;
import flour.model.Millet;
import flour.model.Water;

@Service
public class MillService {
	
	private static final Logger logger = LoggerFactory.getLogger(MillService.class);

	private final static BlockingQueue<Water> waterFlow = new ArrayBlockingQueue<>(10);
	private final static BlockingQueue<Millet> milletFlow = new ArrayBlockingQueue<>(10);
	private final static BlockingQueue<Flour> flourFlow = new ArrayBlockingQueue<>(10);
	
	private Mill mill;
	
	private final ExecutorService waterPipeExecutor = Executors.newSingleThreadExecutor();
	private final ExecutorService milletPipeExecutor = Executors.newSingleThreadExecutor();
	
	public MillService() {
		mill = new Mill(waterFlow, milletFlow, flourFlow);
		mill.start();
	}
	
	public MillState getState() {
		return new MillState(mill, waterFlow, milletFlow, flourFlow);
	}
	
	public void dropFlour() {
		flourFlow.clear();
	}
	
	public void addWater(int capacity) {
		waterPipeExecutor.execute(()->{
			try {
			int counter = capacity;
			while(counter --> 0 ){
				waterFlow.add(new Water());
			}
			} catch(IllegalStateException ex) {
				logger.info("Water tank is full: {}", ex.getMessage());
			}
		});
	}
	
	public void addMillet(int capacity) {
		milletPipeExecutor.execute(()->{
			try {
			int counter = capacity;
			while(counter --> 0 ){
				milletFlow.add(new Millet());
			}
			} catch(IllegalStateException ex) {
				logger.info("Millet tank is full: {}", ex.getMessage());
			}
		});
	}
	
}
