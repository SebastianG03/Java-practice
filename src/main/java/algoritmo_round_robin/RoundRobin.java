package algoritmo_round_robin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin {

    private Queue<Tarea> tareas;
    private final Exception emptyListException = new Exception("No hay elementos en la lista");

    public RoundRobin() {
        tareas = new LinkedList<>();
    }

    public void encolar(Tarea tarea) {
        tareas.add(tarea);
    }

    public String ejecutarAlgoritmo() {
        int quantum = 35;
        int tiempoTotal = 0;
        int taskTime = 0;
        Tarea proceso = null;
        StringBuilder log = new StringBuilder();
        int conmutaciones = 0;

        while(!tareas.isEmpty()) {
            proceso = tareas.peek();
            taskTime = proceso.getTaskTime();

            if(taskTime < quantum) {
                tareas.poll();
                tiempoTotal += quantum - (quantum - taskTime);
            }else if(taskTime > quantum) {
                tiempoTotal += quantum;
                proceso.setTaskTime((taskTime - quantum));
                tareas.poll();
                tareas.add(proceso);
            }else {
                tiempoTotal += quantum;
                tareas.poll();
            }

            log.append("Tiempo ").append(tiempoTotal).append(": ")
                    .append(proceso.getIdentificador())
                    .append(" se conmuta. Pendiente por ejecutar ")
                    .append(proceso.getTaskTime())
                    .append(" ms.\n");
            conmutaciones++;
    }

        return log.append("\n\n").append("Total tiempo de ejecución de todos los procesos: ")
                .append(tiempoTotal)
                .append("ms")
                .append("\nTotal de conmutaciones: ")
                .append(conmutaciones)
                .append(".")
                .toString();
}
}
