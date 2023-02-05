package unique_element_of_list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UniqueElement {

	public static void main(String[] args) {
		int size;
		List<Integer> arr = new ArrayList<>();
		
		try {
			
			do {
				size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número impar: "));
			}while(size % 2 == 0);			
			
			for(int i = 0; i < size; i++)arr.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número: ")));
		
		}catch(NumberFormatException e) {
			JOptionPane.showInputDialog("Número inválido");
			throw(e);	
		}
		
		System.out.println(LonelyInteger.lonelyinteger(arr));
		LonelyInteger.getTreeMap(arr);
		
	}

}
