package counting_sort;

import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Result sorting = new Result();
        
		List<Integer> arr = Stream.of(JOptionPane.showInputDialog("Ingrese un numero: ").replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());
		
		System.out.println(Arrays.toString(sorting.countingSort(arr).toArray()));
		
    }

}
