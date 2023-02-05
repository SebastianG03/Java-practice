package median;

import java.util.List;
import java.util.stream.Collectors;

public class Median {
	List<Integer> arr;
	
	public int median(List<Integer> arr) {
		int n = arr.size();
		this.arr = arr.stream().sorted().collect(Collectors.toList());
		return this.arr.get((n - 1) / 2); 
	}
	
	public void setList(List<Integer> arr) {
		this.arr = arr.stream().sorted().collect(Collectors.toList());	
	}
	
	public List<Integer> getList() {
		return arr;
	}
	
	
}
