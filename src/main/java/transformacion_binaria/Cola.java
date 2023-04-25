package transformacion_binaria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cola {

    private Queue<ToBinary> numberList;
    private Exception emptyListException = new Exception("La lista está vacía");

    public Cola() {
        numberList = new LinkedList<>();
    }

    public void encolar(ToBinary binary) {
        numberList.add(binary);
    }

    public ToBinary desencolar() throws Exception {
        if(numberList.isEmpty()) throw emptyListException;
        return numberList.poll();
    }

    public ToBinary elementoInicial() throws Exception {
        if (numberList.isEmpty()) throw emptyListException;
        return numberList.peek();
    }

    public String toBinaryString() {
        StringBuilder listado = new StringBuilder();
        listado.append("Decimal")
                .append("\t")
                .append("Binario")
                .append("\n");
        for(ToBinary number : numberList)
            listado.append(number)
                    .append("\t")
                    .append(number.toBinaryNumber())
                    .append("\n");

        return listado.toString();
    }

    @Override
    public String toString() {
        StringBuilder listado = new StringBuilder();
        for(ToBinary number : numberList)
            listado.append(number.toString())
                    .append("\n");
        return listado.toString();
    }
}
