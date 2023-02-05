package counting_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

	public static List<Integer> countingSort(List<Integer> arr) {
		
		List<Integer> counter = new ArrayList<>();
		int cont = 0;
		
		for(int i = 0; i < arr.size(); i++) {
			if(Collections.frequency) {
				
			}
			counter.add(arr.get(cont), Collections.frequency(arr, arr.get(cont)));;
			cont++;
		}
		
		return counter;
		
	}
	
}
