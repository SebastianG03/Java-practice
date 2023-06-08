package recursividad_busqueda_binaria;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lista coleccion = new Lista();

        for(int i = 0; i <= 100; i++) {
            coleccion.agregar(new Random().nextInt(5000));
        }

        System.out.println("La cantidad de elementos es " + coleccion.size());
        System.out.println("Suma: " + coleccion.sumar());
        System.out.println("Buscar:");
        Integer dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un dato:"));
        int indice = coleccion.buscar(dato);
        if(indice != -1) {
            System.out.println("El dato se encuentra en el indice " + indice);
        } else System.out.println("El dato no existe");

        System.out.println("Datos:\n" + coleccion.toString());
}
}
