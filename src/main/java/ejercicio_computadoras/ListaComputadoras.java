package ejercicio_computadoras;

import java.util.ArrayList;
import java.util.List;

public class ListaComputadoras {

    List<Computadora> computadoras;

    public ListaComputadoras() {
        this.computadoras = new ArrayList<>();
    }

    public void agregarComputadora(Computadora computadora) {
        if(!idExiste(computadora.getId()))
            this.computadoras.add(computadora);
        else throw new RuntimeException("La computadora ya se encuentra registrada");
    }

    public List<Computadora> filtrarPorMarca(String marca) {
        List<Computadora> computadorasFiltradas = new ArrayList<>();
        for (Computadora computadora : this.computadoras) {
            if (computadora.getMarca().compareTo(marca) == 0) {
                computadorasFiltradas.add(computadora);
            }
        }
        return computadorasFiltradas;
    }

    public boolean idExiste(int id) {
//        for (Computadora computadora : this.computadoras) {
//            if (computadora.getId() == id) {
//                return true;
//            }
//        }

        return computadoras.stream().anyMatch(x -> x.getId() == id);
    }

    public String[] imprimir() {
        String[] str = new String[this.computadoras.size() + 1];

        str[0] = String.format("|%-5s|%-20s|%-20s|%-10s|%-10s|%-5s|\n",
                "Id", "Marca", "Procesador", "Capacidad De Disco", "Precio", "RAM");

        for(int i = 1; i < str.length; ++i) {
            str[i] = this.computadoras.get(i - 1).toString();
        }

        return str;
    }

    public String[] imprimirPorMarca(String marca) {
        List<Computadora> computadoras = this.filtrarPorMarca(marca);
        String[] str = new String[computadoras.size() + 1];
        str[0] = String.format("|%-5s|%-20s|%-20s|%-10s|%-10s|%-5s|\n",
                "Id", "Marca", "Procesador", "Capacidad De Disco", "Precio", "RAM");

        for(int i = 1; i < str.length; ++i) {
            str[i] = computadoras.get(i - 1).toString();
        }

        return str;
    }
}
