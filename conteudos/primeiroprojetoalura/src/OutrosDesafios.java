import java.util.Scanner;

public class OutrosDesafios {
    public static void main(String[] args) {
        // Crie um programa que solicite ao usuário digitar um número. Se o número for positivo, exiba "Número positivo", caso contrário, exiba "Número negativo".

        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um número");
        int numeroDigitado = leitura.nextInt();

        if (numeroDigitado > 0) {
            System.out.println("Número positivo.");
        } else {
            System.out.println("Número negativo.");
        }


        // Peça ao usuário para inserir dois números inteiros. Compare os números e imprima uma mensagem indicando se são iguais, diferentes, o primeiro é maior ou o segundo é maior.

        System.out.println("Digite um número: ");
        int numeroUm = leitura.nextInt();
        System.out.println("Digite outro número: ");
        int numeroDois = leitura.nextInt();

        int resultado;

        // No Java, para comparações de maior/menor, usamos IF
        if (numeroUm == numeroDois) {
            System.out.println("Os números são iguais");
        } else {
            System.out.println("Os números são diferentes.");

            if (numeroUm > numeroDois) {
                System.out.println("O primeiro (" + numeroUm + ") é maior que o segundo (" + numeroDois + ")");
            } else {
                System.out.println("O segundo (" + numeroDois + ") é maior que o primeiro (" + numeroUm + ")");
            }
        }
        leitura.close();
    }
}
