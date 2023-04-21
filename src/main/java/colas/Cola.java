package colas;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    private Queue<Estudiante> listadoEstudiante;

    public Cola() {
        listadoEstudiante = new LinkedList();
    }

    public void encolar(Estudiante dato) {
        listadoEstudiante.add(dato);
    }

    public Estudiante desencolar() throws Exception {
        if(listadoEstudiante.isEmpty())
            throw new Exception("No hay elementos en la lista");
        return listadoEstudiante.poll();
    }

    //Consultar el elemento que esta al inicio de la fila, no elimina el elemento
    public Estudiante elementoInicial() throws Exception {
        if(listadoEstudiante.isEmpty())
            throw new Exception("No hay elementos en la lista");
        return listadoEstudiante.peek();
    }

    @Override
    public String toString() {
        String listado = "";
        for(Estudiante e : listadoEstudiante) {
            listado += e.toString() + "\n\n";
        }
        return listado;
    }
}
