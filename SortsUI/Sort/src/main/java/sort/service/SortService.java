package sort.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import sort.bean.Line;
import sort.bean.SortLog;

abstract public class SortService {

	private static final int LIST_CAPACITY = 100;
	private final Map<String, BlockingDeque<SortLog>> sortLog = new HashMap<>();
	private final Executor executor = Executors.newSingleThreadExecutor();
	
	
	
	public SortLog pollLog(String target) {
		return sortLog.get(target).poll();
	}
	
	abstract protected List<Line> sortList(String target, List<Line> list);
	
	
	public void sort(String target) {
		if(!sortLog.containsKey(target)) {
			List<Line> list = generateList();
			sortLog.put(target, new LinkedBlockingDeque<>());
			executor.execute(()->{
					sortList(target, list);
			});
		}
	}
	
	private List<Line> generateList(){
		Random random = new Random();
		List<Line> res = new LinkedList<>();
		for(int i=0; i<LIST_CAPACITY; i++) {
			res.add(new Line(random.nextInt(LIST_CAPACITY)));
		}
		return res;
	}
	
	protected void addLog(String target, int i, List<Line> list) {
		addLog(target, List.of(i), list);
	}
	
	protected void addLog(String target, List<Integer> i, List<Line> list) {
		sortLog.get(target).addLast(new SortLog(list, i));
	}
	
	public void drop(String target) {
		sortLog.remove(target);
	}
	
	
	
}
