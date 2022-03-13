package flour.model.machine;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flour.model.Flour;
import flour.model.Millet;
import flour.model.engine.Engine;

public class MillStone extends Machine {
	
	private static final Logger logger = LoggerFactory.getLogger(MillStone.class);
	
	private final Engine engine;
	private final Queue<Millet> mallets;
	private final Queue<Flour> floursQueue;
	private final ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public MillStone(Engine engine, Queue<Millet> mallets, Queue<Flour> floursQueue) {
		super();
		this.engine = engine;
		this.mallets = mallets;
		this.floursQueue = floursQueue;
	}

	@Override
	public void run() {
		while(!isInterrupted()) {
			if(engine.getPower() > 0 ) {
				engine.decPower(1);
				try {
					this.executor.submit(()->{
						Millet millet = mallets.poll();
						if(millet!=null) {
							floursQueue.offer(new Flour());
							logger.info("Flour: "+floursQueue.size());
						}
						logger.info("Power left: "+engine.getPower());
					});
					Thread.sleep(500);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
	
	
	
	
	
	
}
