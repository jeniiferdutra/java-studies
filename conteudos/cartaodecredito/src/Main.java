import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartao: ");
        double limiteCartao = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limiteCartao);

        int opcao = 1;
        while (opcao != 0) {
            System.out.println("Digite a descriçao da compra: ");
            String descricaoCompra = leitura.nextLine();

            System.out.println("Digite o valor da compra: ");
            Double valorCompra = leitura.nextDouble();

            Compra compra = new Compra(descricaoCompra, valorCompra);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada.");
                System.out.println("Digite 0 para sair ou 1 para continuar:");
                opcao = leitura.nextInt();

            } else {
                System.out.println("Saldo insuficiente!");
                opcao = 0;
            }
        }
        System.out.println("**********************");
        System.out.println("COMPRAS REALIZADAS:");

        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("\n**********************");
        System.out.println("\nSaldo do cartao: " + limiteCartao);

    }

}
