package ejercicio_computadoras;

public class Computadora {

    private int id;
    private String marca;
    private String procesador;
    private int capacidadDeDiscoAncho;
    private int capacidadDeDiscoLargo;
    private float precio;
    private int ram;

    public Computadora(int id, String marca, String procesador, int capacidadDeDiscoAncho, int capacidadDeDiscoLargo, float precio, int ram) {
        this.id = id;
        this.marca = marca;
        this.procesador = procesador;
        this.capacidadDeDiscoAncho = capacidadDeDiscoAncho;
        this.capacidadDeDiscoLargo = capacidadDeDiscoLargo;
        this.precio = precio;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getCapacidadDeDiscoAncho() {
        return capacidadDeDiscoAncho;
    }

    public int getCapacidadDeDiscoLargo() {
        return capacidadDeDiscoLargo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getRam() {
        return ram;
    }
}
