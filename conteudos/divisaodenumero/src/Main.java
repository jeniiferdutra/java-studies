import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        int numero01 = leitura.nextInt();

        System.out.println("Digite o segundo número:");
        int numero02 = leitura.nextInt();

        try {
            int resposta = numero01 / numero02;
            System.out.println("A resposta é: " + resposta);
        } catch (ArithmeticException e) {
            System.out.println("Nao é possivel dividir com o número zero, digite outro numero.");
        }
    }
}