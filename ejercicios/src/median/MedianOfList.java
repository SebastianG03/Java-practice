package median;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import javax.swing.JOptionPane;

public class MedianOfList {

	public static void main(String[] args) {
		int size;
		Median m = new Median();
		List<Integer> arr = new ArrayList<>();
		
		do {
			size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número impar: "));
		}while(size % 2 == 0);
		
		for(int i = 0; i < size; i++)arr.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número: ")));
		
		m.setList(arr);
		System.out.println(m.median(arr));
		System.out.println(m.getList());
	}
}