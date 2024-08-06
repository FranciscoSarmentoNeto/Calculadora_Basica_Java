import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    static JFrame frame;
    static JTextField num1Field;
    static JTextField num2Field;
    static JLabel resultLabel;

    public static void main(String[] args) {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        JLabel num1Label = new JLabel("Primeiro número:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(num1Label, constraints);

        num1Field = new JTextField(20);
        constraints.gridx = 1;
        panel.add(num1Field, constraints);

        JLabel num2Label = new JLabel("Segundo número:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(num2Label, constraints);

        num2Field = new JTextField(20);
        constraints.gridx = 1;
        panel.add(num2Field, constraints);

        JButton addButton = new JButton("Somar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(addButton, constraints);

        JButton subButton = new JButton("Subtrair");
        constraints.gridx = 1;
        panel.add(subButton, constraints);

        JButton mulButton = new JButton("Multiplicar");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(mulButton, constraints);

        JButton divButton = new JButton("Dividir");
        constraints.gridx = 1;
        panel.add(divButton, constraints);

        resultLabel = new JLabel("Resultado:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(resultLabel, constraints);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                somaNumeros();
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subtrairNumeros();
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multipicarNumeros();
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dividirNumeros();
            }
        });
    }

    private static void somaNumeros() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            int resultado = a + b;
            resultLabel.setText("Resultado da soma: " + resultado);
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira números válidos.");
        }
    }

    private static void subtrairNumeros() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            int resultado = a - b;
            resultLabel.setText("Resultado da subtração: " + resultado);
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira números válidos.");
        }
    }

    private static void multipicarNumeros() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            int resultado = a * b;
            resultLabel.setText("Resultado da multiplicação: " + resultado);
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira números válidos.");
        }
    }

    private static void dividirNumeros() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            if (b == 0) {
                resultLabel.setText("Não é possível realizar divisão por zero.");
            } else {
                int resultado = a / b;
                resultLabel.setText("Resultado da divisão: " + resultado);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira números válidos.");
        }
    }
}
