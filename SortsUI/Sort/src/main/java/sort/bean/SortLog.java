package sort.bean;

import java.util.Date;
import java.util.List;

public class SortLog extends Line {

	private Long tm;
	private List<Line> list;
	private List<Integer> index;
	
	public SortLog(List<Line> list, List<Integer> indexes) {
		this.tm=new Date().getTime();
		this.list = list;
		this.index = indexes;
	}
	public Long getTm() {
		return tm;
	}

	public List<Line> getList() {
		return list;
	}
	public List<Integer> getIndex() {
		return index;
	}

	
	
	
	
}
