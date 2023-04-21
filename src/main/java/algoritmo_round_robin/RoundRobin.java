package algoritmo_round_robin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin {

    private Queue<Tarea> tareas;
    private final long quantum = 35000000;
    private final Exception emptyListException = new Exception("No hay elementos en la lista");

    public RoundRobin() {
        tareas = new LinkedList<>();
    }

    public void encolar(Tarea tarea) {
        tareas.add(tarea);
    }

    public void ejecutarAlgoritmo() {
        long tiempoTotal = 0;
        long currentTime = System.nanoTime();
        long taskTime = 0;
        Tarea proceso = null;
        String log = "";

        while(!tareas.isEmpty()) {
            if(proceso == null) {
                proceso = tareas.peek();
                taskTime = proceso.getTaskTime() * 1000000;
            }

            if(taskTime < quantum) {
                proceso = null;
                tareas.poll();
                tiempoTotal += quantum - (quantum - taskTime);
            }else if(taskTime > quantum) {
                tiempoTotal += quantum;
                proceso.setTaskTime(taskTime - quantum);
                tareas.poll();
                tareas.add(proceso);
                proceso = null;
            }else if(taskTime == quantum) {
                tiempoTotal += quantum;
                tareas.poll();
                proceso = null;
            }
    }
}
}
