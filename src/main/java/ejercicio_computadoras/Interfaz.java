package ejercicio_computadoras;

import ejercicio_computadoras.DocumentFilter.FilterFormat;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textFieldId;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxProcesador;
    private JSpinner spinnerAncho;
    private JSpinner spinnerSizeLargo;
    private JTextField textFieldPrecio;
    private JSpinner spinnerRAM;
    private JButton agregarButton;
    private JList listComputadorasIngresadas;
public Interfaz() {
    spinnerAncho.setModel(new SpinnerNumberModel(0, 1, 99, 1));
    spinnerSizeLargo.setModel(new SpinnerNumberModel(0, 1, 99, 1));
    spinnerRAM.setModel(new SpinnerNumberModel(0, 1, 99, 1));
    FilterFormat idFormat = new FilterFormat(10, "[0-9]*[.]?");

    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
