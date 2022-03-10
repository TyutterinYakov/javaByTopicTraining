package sort.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sort.bean.Line;

@Service
public class QuickSortService extends SortService{

	@Override
	protected List<Line> sortList(String target, List<Line> list) {
		return sortList(target, list, 0, list.size()-1);
	}
	
	private List<Line> sortList(String target, List<Line> list, int left, int rigth){
		if(left < rigth) {
			int partitionIndex = partition(target, list, left, rigth);
			
			sortList(target, list, left, partitionIndex-1);
			sortList(target, list, partitionIndex+1, rigth);
		}
		return list;
	}

	private int partition(String target, List<Line> list, int left, int rigth) {
		int counter = left;
		for(int i=left; i<rigth; i++) {
			if(list.get(i).compare(list.get(rigth))){
				Line temp = list.get(counter);
				list.set(counter, list.get(i));
				list.set(i, temp);
				addLog(target, counter, list);
				counter++;
			}
		}
		Line temp = list.get(rigth);
		list.set(rigth, list.get(counter));
		list.set(counter, temp);
		addLog(target, counter, list);
		return counter;
	}

	
}
