package algoritmo_round_robin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.stream.Collectors;

public class Form {
    private JTextField txtIdentificador;
    private JTextField txtCedula;
    private JButton btnEncolar;
    private JTextArea txtArea;
    private JButton btnEjecutarAlgoritmo;
    private JPanel Principal;
    private JSpinner jsTaskTime;
    private RoundRobin roundRobin = new RoundRobin();
public Form() {

    btnEncolar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String list = "";
            String identificador = txtIdentificador.getText();
            int cedula = 0;
            try {
                cedula = Integer.parseInt(txtCedula.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Cédula incorrecta, la cédula ingresada contiene" +
                        " más de 9 dígitos");
            }
            int taskTime = Integer.parseInt(jsTaskTime.getValue().toString());

            if(identificador != null || cedula != 0) {
                roundRobin.encolar(new Tarea(identificador, cedula, taskTime));
                JOptionPane.showMessageDialog(null, "Proceso " + identificador +
                        " ha sido encolado exitosamente");
                list = roundRobin.toList().stream().map(Tarea::toString).collect(Collectors.joining("\n"));
                txtArea.setText(list);
            } else JOptionPane.showMessageDialog(null, "No se pudo encolar el proceso" +
                    " verifique que todos los campos hayan sido llenados correctamente.");
        }
    });
    txtCedula.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            if(txtCedula.getText().length() > 9) e.consume();
        }
    });
    btnEjecutarAlgoritmo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, roundRobin.ejecutarAlgoritmo());
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new Form().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        SpinnerNumberModel model = new SpinnerNumberModel(10, 5, 900, 5);
        jsTaskTime = new JSpinner(model);
    }
}
