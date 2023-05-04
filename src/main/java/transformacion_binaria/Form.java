package transformacion_binaria;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    private JTextField txtBinaryField;
    private JButton btnEncolar;
    private JTextArea txtArea;
    private JButton btnToBinary;
    private JButton btnLimpiarCampos;
    private JPanel principal;
    private Pila pila = new Pila();
    private long number = 0L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new Form().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

    public Form() {
    btnEncolar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                number = Long.parseLong(txtBinaryField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
            pila.encolar(new ToBinary(number));
            txtArea.setText(pila.toString());
        }
    });
    btnToBinary.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtArea.setText(pila.toBinaryString());
            pila.limpiarElementos();
        }
    });
    btnLimpiarCampos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtBinaryField.setText("");
            txtArea.setText("");
        }
    });

}
}
