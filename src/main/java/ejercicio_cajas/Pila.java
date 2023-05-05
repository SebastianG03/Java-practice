package ejercicio_cajas;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Pila {

    private Stack<Cajas> firstPila;
    private Stack<Cajas> secondPila;
    private Stack<Cajas> thirdPila;
    private Exception fullListException = new Exception("No hay espacio disponible en la pila.");

    public Pila() {
        firstPila = new Stack<>();
        secondPila = new Stack<>();
        thirdPila = new Stack<>();
    }

    public void push(Cajas caja, int index) throws Exception {
        try {
            if(index == 1 && firstPila.size() <= 6) firstPila.push(caja);
            else if(index == 2 && secondPila.size() <= 6) secondPila.push(caja);
            else if(index == 3 && this.firstPila.size() <= 6) thirdPila.push(caja);
        } catch (Exception e) {
            throw fullListException;
        }
    }

    public boolean exists(Long serialKey) {
        List<Cajas> list;

        if(firstPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            list = firstPila.stream().toList();
        } else if(secondPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            list = secondPila.stream().toList();
        } else list = thirdPila.stream().toList();

        for(Cajas caja : list) {
            if(caja.getSerialKey().equals(serialKey)) {
                return true;
            }
        }
        return false;
    }

    public int whereIs(Long serialKey) {

        if(firstPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            return 1;
        } else if(secondPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            return 2;
        } else if(thirdPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) return 3;
        return 0;
    }

    public String findByKey(Long serialKey) {
        String found = "La caja se encuentra en la pila N°%d y en la posición %d";
        String notFound = "La caja con el número de serie " + serialKey + " no se encuentra registrada.";
        int[] data = new int[2];
        List<Cajas> list;
        int cont = 1;

        if(firstPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            list = firstPila.stream().toList();
        } else if(secondPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst() != null) {
            list = secondPila.stream().toList();
        } else list = thirdPila.stream().toList();

        for(Cajas caja : list) {
            if(caja.getSerialKey().equals(serialKey)) {
                data = new int[]{1, cont};
                break;
            }
            cont++;
        }

        return (data[0] == 0 && data[1] == 0)? notFound : String.format(found, data[0], data[1]);
    }

    public Cajas getByKey(Long serialKey) throws Exception {
        Cajas caja = null;

        if(exists(serialKey)) {
            if(whereIs(serialKey) == 1) {
                caja = firstPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst().orElse(null);
                firstPila.remove(caja);
            } else if(whereIs(serialKey) == 2) {
                caja = secondPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst().orElse(null);
                secondPila.remove(caja);
            } else {
                caja = thirdPila.stream().filter(x -> x.getSerialKey().equals(serialKey)).findFirst().orElse(null);
                thirdPila.remove(caja);
            }
        } else {
            throw new Exception("La caja con el número de serie " + serialKey + " no se encuentra en ninguna pila.");
        }
        return caja;
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder();

        sb.append(firstPila.stream().map(x -> x.toString()).collect(Collectors.joining("\n")));
        sb.append(secondPila.stream().map(x -> x.toString()).collect(Collectors.joining("\n")));
        sb.append(thirdPila.stream().map(x -> x.toString()).collect(Collectors.joining("\n")));

        return sb.toString();
    }
}
