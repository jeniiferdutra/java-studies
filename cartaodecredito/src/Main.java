import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        List<String> historicoDeCompras = new LinkedList<>();

        System.out.println("Digite o limite do cartao: ");
        double limiteCartao = leitura.nextDouble();

        int opcao = 1;

        while (opcao != 0) {

            switch (opcao) {
                case 1:
                    leitura.nextLine();
                    System.out.println("Digite a descriçao da compra: ");
                    String descricaoCompra = leitura.nextLine();

                    System.out.println("Digite o valor da compra: ");
                    Double valorCompra = leitura.nextDouble();

                    if (valorCompra <= limiteCartao) {
                        limiteCartao -= valorCompra;
                        historicoDeCompras.add(descricaoCompra + " - " + valorCompra);
                        System.out.println("Compra realizada.");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                default:
                    System.out.println("Opçao inválida.");
                    break;
            }
            if (opcao != 0) {
                System.out.println("\nDigite 0 para sair ou 1 para continuar:");
                opcao = leitura.nextInt();
            }
        }

        System.out.println("**********************");
        System.out.println("COMPRAS REALIZADAS:");
        for (String item : historicoDeCompras) {
            System.out.println(item);
        }
        System.out.println("\n**********************");
        System.out.println("\nSaldo do cartao: " + limiteCartao);
    }
}