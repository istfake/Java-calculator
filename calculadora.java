import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora {

    private JFrame frame;
    private JTextField textField;
    private double numero1 = 0;
    private String operacao = "";

    public calculadora() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        textField = new JTextField();
        container.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String botao : botoes) {
            JButton button = new JButton(botao);
            button.addActionListener(new BotaoClickListener());
            panel.add(button);
        }

        container.add(panel, BorderLayout.CENTER);

        // Botão de reset
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetClickListener());
        container.add(resetButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private class BotaoClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton botao = (JButton) event.getSource();
            String textoBotao = botao.getText();

            switch (textoBotao) {
                case "=":
                    double numero2 = Double.parseDouble(textField.getText());
                    double resultado = 0;
                    switch (operacao) {
                        case "+":
                            resultado = numero1 + numero2;
                            break;
                        case "-":
                            resultado = numero1 - numero2;
                            break;
                        case "*":
                            resultado = numero1 * numero2;
                            break;
                        case "/":
                            if (numero2 != 0) {
                                resultado = numero1 / numero2;
                            } else {
                                JOptionPane.showMessageDialog(frame, "Erro: divisão por zero não é permitida!");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Erro: operação inválida!");
                            break;
                    }
                    textField.setText(String.valueOf(resultado));
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operacao = textoBotao;
                    numero1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                    break;
                default:
                    String textoAtual = textField.getText();
                    textField.setText(textoAtual + textoBotao);
                    break;
            }
        }
    }

    private class ResetClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            numero1 = 0;
            operacao = "";
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculadora();
            }
        });
    }
}
