package recursividad_busqueda_binaria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lista {

    private List<Integer> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public void agregar(Integer valor) {
        if(!lista.contains(valor)) {
            lista.add(valor);
            lista.stream().sorted();
            //Collections.sort(valor);
        }
    }

    public void agregarInicio(Integer valor) {
        lista.add(0, valor);
    }

    public Integer eliminarValor(int index) {
        return lista.remove(index);
    }

    public int size() {
        return lista.size();
    }

    private int buscarBinario(Integer valor) {
        int inf, sup, centro, dato;
        inf = 0;
        sup = lista.size() - 1;

        while(sup >= inf) {
            centro = (inf + sup) / 2;
            dato = lista.get(centro);
            if(dato == valor)
                return centro;
            if(valor < dato)
                sup = centro - 1;
            else inf = centro + 1;
        }
        return -1;
    }

    private Integer sumaRecursiva(int indiceActual) {
        return (indiceActual >= lista.size())? 0 :
                lista.get(indiceActual) + sumaRecursiva(indiceActual + 1);
    }


    public Integer sumar() {
        return sumaRecursiva(0);
    }

    public int buscar(Integer valor) {
        if(valor < lista.get(0) || valor > lista.get(lista.size() - 1))
            return -1; //No se encuentra en la lista.
        return buscarBinario(valor);
    }


    @Override
    public String toString() {
        return lista.stream().map(x -> Integer.toString(x)).collect(Collectors.joining("\t"));
    }
}


