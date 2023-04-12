import java.util.Scanner;

public class calculator {

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        double numero1, numero2, resultado;
        String operacao;

        System.out.println("Digite o primeiro número: ");
        numero1 = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        numero2 = scanner.nextDouble();

        System.out.println("Digite a operação (+, -, *, /): ");
        operacao = scanner.next();

        switch (operacao) {
            case "+":
                resultado = numero1 + numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case "-":
                resultado = numero1 - numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case "*":
                resultado = numero1 * numero2;
                System.out.println("Resultado: " + resultado);
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Erro: divisão por zero não é permitida!");
                }
                break;
            default:
                System.out.println("Erro: operação inválida!");
        }

        scanner.close();
    }
}