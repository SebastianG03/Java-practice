package unique_element_of_list;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LonelyInteger {
	public static int lonelyinteger(List<Integer> a) {
		int unique = 0;
		
		TreeMap<Integer, Integer> counts = new TreeMap<>();
		
		for(int i : a) {
			Integer j = counts.get(i);
			counts.put(i, (j == null)? 1 : j + 1);
		}
		
		for(Map.Entry m : counts.entrySet()) unique = (m.getValue().equals(1))? (int)m.getKey() : 0;
		
		return unique;
		
	}
	
	public static void getTreeMap(List<Integer> a) {
		
		TreeMap<Integer, Integer> counts = new TreeMap<>();
		
		for(int i : a) {
			Integer j = counts.get(i);
			counts.put(i, (j == null)? 1 : j + 1);
		}
		
		for(Map.Entry m : counts.entrySet())
			System.out.println("La frecuencia de " + m.getKey() + " es: " + m.getValue());
		
	}
}
