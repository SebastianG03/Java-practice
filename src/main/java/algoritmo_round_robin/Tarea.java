package algoritmo_round_robin;

public class Tarea {
    private String identificador;
    private int cedula;
    private long taskTime;

    public Tarea(String identificador, int cedula, long taskTime) {
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

    public long getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(long taskTime) {
        this.taskTime = taskTime;
    }

    public long calcularTiempoRestante(long quantum) {
        return quantum - taskTime;
    }

    @Override
    public String toString() {
        return "Proceso " + identificador
                +"\nCédula: " + cedula +
                "\nTiempo(ms)" + taskTime;
    }
}
