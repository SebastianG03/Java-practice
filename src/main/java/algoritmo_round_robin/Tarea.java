package algoritmo_round_robin;

public class Tarea {
    private String identificador;
    private int cedula;
    private int taskTime;

    public Tarea(String identificador, int cedula, int taskTime) {
        this.identificador = identificador;
        this.cedula = cedula;
        this.taskTime = taskTime;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }

    @Override
    public String toString() {
        return "Proceso " + identificador
                +"\nCédula: " + cedula +
                "\nTiempo: " + taskTime + "ms\n";
    }
}
