package ejercicio_computadoras;

import ejercicio_computadoras.DocumentFilter.FilterFormat;

import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ventana {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldId;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxProcesador;
    private JSpinner spinnerLargo;
    private JSpinner spinnerAncho;
    private JTextField textFieldPrecio;
    private JSpinner spinnerRAM;
    private JButton buttonIngresar;
    private JList<String> listComputadorasIngresadas;
    private ListaComputadoras listaComputadoras = new ListaComputadoras();

    public Ventana() {
        spinnerAncho.setModel(new SpinnerNumberModel(10, 1, 130, 10));
        ((DefaultEditor)spinnerAncho.getEditor()).getTextField().setEditable(false);
        spinnerLargo.setModel(new SpinnerNumberModel(10, 1, 130, 10));
        ((DefaultEditor)spinnerLargo.getEditor()).getTextField().setEditable(false);
        spinnerRAM.setModel(new SpinnerNumberModel(4, 4, 64, 4));
        ((DefaultEditor)spinnerRAM.getEditor()).getTextField().setEditable(false);
        listComputadorasIngresadas.setLayoutOrientation(JList.VERTICAL);
        DefaultListModel<String> model = new DefaultListModel<>();
        listComputadorasIngresadas.setModel(model);
        actualizarLista(model);

        buttonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldId.getText());
                String marca = Objects.requireNonNull(comboBoxMarca.getSelectedItem()).toString();
                String procesador = Objects.requireNonNull(comboBoxProcesador.getSelectedItem()).toString();
                int capacidadDeDiscoAncho = Integer.parseInt(spinnerAncho.getValue().toString());
                int capacidadDeDiscoLargo = Integer.parseInt(spinnerLargo.getValue().toString());
                float precio = Float.parseFloat(textFieldPrecio.getText().strip());
                int ram = Integer.parseInt(spinnerRAM.getValue().toString());

                if(!listaComputadoras.idExiste(id)) {
                    listaComputadoras.agregarComputadora(new Computadora(id, marca, procesador, capacidadDeDiscoAncho, capacidadDeDiscoLargo, precio, ram));
                    actualizarLista(model);
                } else JOptionPane.showMessageDialog(null, "La computadora ya existe. Ingrese otra Id");
            }
        });
    }

    public void actualizarLista(DefaultListModel<String> model) {
        model.clear();
        String[] computadoras = listaComputadoras.imprimir();
        if(listaComputadoras.imprimir() != null) {
            for(String str : computadoras) {
                model.addElement(str);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        textFieldId = new FilterFormat().filterFormatField(8, "[0-9]*");
        textFieldPrecio = new FilterFormat().filterFormatField(8, "[0-9]*[\\.]?[0-9]*");
    }
}
