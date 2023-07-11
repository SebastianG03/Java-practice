package arboles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ventana {
    private JSpinner spinnerCodigo;
    private JTextField textFieldNombre;
    private JComboBox comboBoxDepartamento;
    private JTextField textFieldSalario;
    private JButton insertarNuevoEmpleadoButton;
    private JTextArea empleadosTextArea;
    private JButton preOrdenButton;
    private JButton postOrdenButton;
    private JButton inOrdenButton;
    private JPanel Ventana;
    private Arbol listaEmpleados = new Arbol();

public Ventana() {
    insertarNuevoEmpleadoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int codigo = Integer.parseInt(spinnerCodigo.getValue().toString());
            String nombre = textFieldNombre.getText();
            String departamento = Objects.requireNonNull(comboBoxDepartamento.getSelectedItem()).toString();
            float salario = Float.parseFloat(textFieldSalario.getText());
            Empleado empleado = new Empleado(codigo, nombre, departamento, salario);

            listaEmpleados.insertar(empleado);
            empleadosTextArea.setText("Lista de empleados");
        }
    });
    preOrdenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            empleadosTextArea.append("\n" + listaEmpleados.preOrden());
        }
    });
    inOrdenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            empleadosTextArea.append("\n" + listaEmpleados.inOrden());
        }
    });
    postOrdenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            empleadosTextArea.append("\n" + listaEmpleados.posOrden());
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

