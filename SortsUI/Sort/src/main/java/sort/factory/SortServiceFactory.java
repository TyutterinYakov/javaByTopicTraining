package sort.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import sort.bean.SortType;
import sort.service.BubbleSortService;
import sort.service.QuickSortService;
import sort.service.SortService;

@Component
public class SortServiceFactory {
	private final BubbleSortService bubbleSortService;
	private final QuickSortService quickSortService;
	
	private static final Map<SortType, SortService> handler = new HashMap<>();
	
	
	@Bean
	private void defineHandler() {
		handler.put(SortType.BUBBLE_SORT, bubbleSortService);
		handler.put(SortType.QUICK_SORT, quickSortService);
	}
		
	
	@Autowired
	public SortServiceFactory(BubbleSortService bubbleSortService, QuickSortService quickSortService) {
		super();
		this.bubbleSortService = bubbleSortService;
		this.quickSortService = quickSortService;
	}
	
	public SortService get(SortType type) {
		return handler.get(type);
	}
	
	
}
