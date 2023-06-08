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

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        String titles = "|Id\t|Marca|\tProcesador|\tCapacidadDeDiscoAncho|\tCapacidadDeDiscoLargo|" +
                "\tPrecio|\tRam|\n";
        String formatBody = "|%-5d\t|%-20s|\t%-20s|\t%-5d|\t%-5d|\t%-10.2f|\t%-5d|\n";
        sb.append(titles);

        for (Computadora computadora : this.computadoras) {
            sb.append(String.format(formatBody, computadora.getId(), computadora.getMarca(),
                    computadora.getProcesador(), computadora.getCapacidadDeDiscoAncho(),
                    computadora.getCapacidadDeDiscoLargo(), computadora.getPrecio(), computadora.getRam()));
        }

        return sb.toString();
    }

    public String imprimirPorMarca(String marca) {
        List<Computadora> computadoras = this.filtrarPorMarca(marca);
        StringBuilder sb = new StringBuilder();
        String titles = "|Id\t|Marca|\tProcesador|\tCapacidadDeDiscoAncho|\tCapacidadDeDiscoLargo|" +
                "\tPrecio|\tRam|\n";
        String formatBody = "|%-5d\t|%-20s|\t%-20s|\t%-5d|\t%-5d|\t%-10.2f|\t%-5d|\n";
        sb.append(titles);

        for (Computadora computadora : computadoras) {
            sb.append(String.format(formatBody, computadora.getId(), computadora.getMarca(),
                    computadora.getProcesador(), computadora.getCapacidadDeDiscoAncho(),
                    computadora.getCapacidadDeDiscoLargo(), computadora.getPrecio(), computadora.getRam()));
        }

        return sb.toString();
    }
}
