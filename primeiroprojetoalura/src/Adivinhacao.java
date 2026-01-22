import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int numeroGerado = new Random().nextInt(100);
        int tentativas = 0;

        for (int i = 1; i < 5; i++) {
            System.out.println("Digite um número de 0 a 100 e tente adivinhar o número:");
            int chute = leitura.nextInt();

            if (chute == numeroGerado) {
                System.out.println("Parabéns! Você acertou o número " + numeroGerado + "!");
                break;
            } else if (chute < numeroGerado) {
                System.out.println("O número gerado é MAIOR que " + chute);
            } else {
                System.out.println("O número gerado é MENOR que " + chute);
            }
            tentativas = i;
        }
        if (tentativas == 5) {
            System.out.println("Que pena! O número era: " + numeroGerado);
        }
        leitura.close();
    }
}
