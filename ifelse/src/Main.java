import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Ana precisa identificar se um número é par ou ímpar para um jogo que está desenvolvendo. Para isso, deseja criar um programa que analisa se o número que ela definiu previamente é par ou ímpar.

        int numero = 7;

        if(numero % 2 == 0) {
            System.out.println("O numero " + numero + " é par");
        } else {
            System.out.println("O numero " + numero + " é impar");
        }

        System.out.println("-------------------------------------");

        double nota1 = 5.7;
        double nota2 = 7.0;
        double nota3 = 3.4;
        double media = (nota1 + nota2 + nota3) / 3;

        if(media >= 7.0) {
            System.out.println("O estudante teve uma média " + media + "e foi aprovado.");
        } else if(media >= 5.0 && media <= 6.9) {
            System.out.println("O estudante teve uma média " + media + "e esta de recuperacao.");
        } else {
            System.out.println("O estudante teve uma média " + media + "e foi reprovado.");
        }

        System.out.println("-------------------------------------");

        //Ajude Jéssica a criar um programa que, com base em uma senha pré-definida, por exemplo: 123456, verifique se o que o usuário digitou está correto ou não. O programa deve comparar a tentativa com a senha correta e exibir se o acesso foi permitido ou negado.

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite a senha:");
        int password = leitura.nextInt();
        int senha = 123456;

        if(password != senha) {
            System.out.println("Acesso negado!");
        } else {
            System.out.println("Acesso permitido!");
        }

    }
}