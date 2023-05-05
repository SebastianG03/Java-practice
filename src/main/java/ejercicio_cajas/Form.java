package ejercicio_cajas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    private JButton xButton;
    private JPanel principal;
    private JComboBox comboBoxPila;
    private JTextField textFieldCompanyName;
    private JButton ingresarButton;
    private JTextArea textArea;
    private JTextField textFieldSerialKey;
    private JButton buscarButton;
    private JButton obtenerCajaButton;
    private JButton imprimirCajasButton;
    private Pila pila = new Pila();
public Form() {

    ingresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Long serialKey = Long.parseLong(textFieldSerialKey.getText());
            String companyName = textFieldCompanyName.getText();

            try {
                if(!pila.exists(serialKey)) {
                    pila.push(new Cajas(serialKey, companyName), Integer.parseInt(comboBoxPila.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(null,"Agregado");
                } else JOptionPane.showMessageDialog(null, "El código " + serialKey + " ya está en uso" +
                        " intente otro");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nIntente con otra pila");
            }
            textFieldCompanyName.setText("");
            textFieldCompanyName.setText("");
        }
    });
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String option = (String) JOptionPane.showInputDialog(null, "Ingrese el código de la caja:", "Buscar",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Buscar", "Cancelar"}, null);
            textArea.setText("");
            textArea.setText(pila.findByKey(Long.parseLong(option)));
        }
    });
    obtenerCajaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String option = (String) JOptionPane.showInputDialog(null, "Ingrese el código de la caja:", "Buscar",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Buscar", "Cancelar"}, null);
            Cajas caja = null;
            try {
                caja = pila.getByKey(Long.parseLong(option));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            textArea.setText("");
            textArea.setText(caja.toString());
        }
    });
    imprimirCajasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            textArea.setText(pila.printAll());
        }
    });
    xButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new Form().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(480, 720);
        frame.setVisible(true);
    }
}
