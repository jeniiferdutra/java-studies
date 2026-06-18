import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Carla começou a praticar trilha e deseja saber quantos degraus precisará subir para chegar ao topo de uma escadaria. Ela sobe um degrau por vez e quer um programa que mostre sua subida até o topo. Sua tarefa é criar um programa que receba um número e simule a subida da escadaria.

        int totalDegraus = 3;
        int degrauAtual = 1;

        while(degrauAtual <= totalDegraus) {
            System.out.println("Subindo o degrau " + degrauAtual);
            degrauAtual++;
        }
        System.out.println("Vc chegou ao topo!!");

        System.out.println("-----------------------------------");

        // João recebeu uma lista de valores representando as receitas de sua loja de roupas. Ele quer calcular a soma total dessas receitas para entender o desempenho financeiro semanal.

        int[] valores = {10, 20, 30, 40, 50};
        int soma = 0;

        for(int somaTotal : valores) {
            soma += somaTotal;
        }
        System.out.println("A soma total das receitas é: " + soma);

        System.out.println("-----------------------------------");

        // Maria quer calcular a soma de todos os números pares de 1 a 100. Ela decidiu usar um loop para iterar pelos números e somar apenas aqueles divisíveis por 2. Crie um programa que realize essa tarefa.

        int numerosPares = 0;
        for (int num = 1; num <= 100; num++) {
            if(num % 2 == 0) {
                numerosPares += num;
            }
        }
        System.out.println("A soma dos números pares de 1 a 100 é: " + numerosPares);

        System.out.println("-----------------------------------");

        // Carlos tem uma lista de números e quer descobrir qual é o maior valor. Para isso, ele decidiu percorrer a lista comparando cada número com o maior encontrado até o momento. Crie um programa que receba uma lista de números e encontre o maior número.

        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite os números separados por espaço: ");
        String[] numerosStr = leitura.nextLine().split(" ");
        int maior = Integer.MIN_VALUE;

        for (String numStr : numerosStr) {
            int num = Integer.parseInt(numStr);
            if (num > maior) {
                maior = num;
            }
        }
        System.out.println("O maior número é: " + maior);
        leitura.close();
    }
}