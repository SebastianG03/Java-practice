package transformacion_binaria;

import java.util.LinkedList;
import java.util.Stack;

public class Pila {

    private Stack<ToBinary> numberList;
    private Exception emptyListException = new Exception("La lista está vacía");

    public Pila() {
        numberList = new Stack<>();
    }

    public void encolar(ToBinary binary) {
        numberList.add(binary);
    }

    public ToBinary desencolar() throws Exception {
        if(numberList.isEmpty()) throw emptyListException;
        return numberList.pop();
    }

    public ToBinary elementoInicial() throws Exception {
        if (numberList.isEmpty()) throw emptyListException;
        return numberList.peek();
    }

    public void limpiarElementos() {
        numberList.clear();
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
