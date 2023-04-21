package colas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    private JPanel Principal;
    private JSpinner spCodigo;
    private JTextField txtNombre;
    private JTextArea txtListaEstudiantes;
    private JComboBox cboCreditos;
    private JButton btnAgregarEstudiante;
    private JButton btnConsultar;
    private JButton btnDesencolar;
    private Cola filaEstudiante = new Cola();
    private Estudiante estudiante;
public Formulario() {
    btnAgregarEstudiante.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int codigo = Integer.parseInt(spCodigo.getValue().toString());
            String nombre = txtNombre.getText();
            int creditos = Integer.parseInt(cboCreditos.getSelectedItem().toString());
            estudiante = new Estudiante(codigo, nombre, creditos);
            filaEstudiante.encolar(estudiante);

            txtListaEstudiantes.setText(filaEstudiante.toString());
        }
    });
    btnConsultar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Estudiante estudiante = filaEstudiante.elementoInicial();
                JOptionPane.showMessageDialog(null, estudiante.toString() +
                        "\nDebe pagar " + estudiante.valorMatricula());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    btnDesencolar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                filaEstudiante.desencolar();
                txtListaEstudiantes.setText(filaEstudiante.toString());
                JOptionPane.showMessageDialog(null, "Estudiante atendido");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 700);
        frame.setVisible(true);
    }
}