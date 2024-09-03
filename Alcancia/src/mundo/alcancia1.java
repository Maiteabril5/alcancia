package mundo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alcancia1 extends JFrame {

    private JTextField[] inputFields;
    private JLabel totalLabel;

    public alcancia1() {
        setTitle("Alcancía");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        String[] denominaciones = {"$50", "$100", "$200", "$500", "$1000"};
        inputFields = new JTextField[denominaciones.length];

        for (int i = 0; i < denominaciones.length; i++) {
            JLabel label = new JLabel("Cantidad de monedas de " + denominaciones[i] + ":");
            inputFields[i] = new JTextField("0");
            add(label);
            add(inputFields[i]);
        }

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificarCantidadMonedas()) {
                    calcularTotal();
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad total de monedas no puede exceder 1000.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        totalLabel = new JLabel("Valor total ahorrado en la alcancía: $0");

        add(calcularButton);
        add(new JLabel()); 
        add(totalLabel);

        setVisible(true);
    }

    private boolean verificarCantidadMonedas() {
        int totalMonedas = 0;

        for (JTextField inputField : inputFields) {
            totalMonedas += Integer.parseInt(inputField.getText());
        }

        return totalMonedas <= 1000;
    }

    private void calcularTotal() {
        int[] valores = {50, 100, 200, 500, 1000};
        int totalAhorrado = 0;

        for (int i = 0; i < valores.length; i++) {
            int cantidad = Integer.parseInt(inputFields[i].getText());
            totalAhorrado += cantidad * valores[i];
        }

        totalLabel.setText("Valor total ahorrado en la alcancía: $" + totalAhorrado);
    }

    public static void main(String[] args) {
        new Alcancia();
    }
}
