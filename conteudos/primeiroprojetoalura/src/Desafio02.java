import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Variáveis de ACÚMULO (ficam fora do loop para não resetarem)
        double valorTotalEstoque = 0;
        int totalItensEstoque = 0;
        int contadorProdutosDiferentes = 0;

        String menu = """
                *** Menu Principal ***
                1 - Adicionar Produto
                2 - Exibir Relatório e Sair
                """;
        int opcao = 0;

        while (opcao != 2) {
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine(); // LIMPEZA DE BUFFER: consome o "Enter" do nextInt

            if (opcao == 1) {
                System.out.println("Digite o nome do produto: ");
                String nomeProduto = leitura.nextLine();

                System.out.println("Digite a quantidade do respectivo produto: ");
                int quantidade = leitura.nextInt();

                System.out.println("Informe o valor unitário: ");
                double preco = leitura.nextDouble();
                double valorDesteProduto = quantidade * preco;
                valorTotalEstoque += valorDesteProduto; // Soma ao total geral
                totalItensEstoque += quantidade;        // Soma a quantidade geral
                contadorProdutosDiferentes++;           // Conta mais um produto

                System.out.println("Produto " + nomeProduto + " adicionado com sucesso!");
                System.out.println("Subtotal deste item: R$ " + valorDesteProduto);

            } else if (opcao == 2){
                System.out.println("\n--- RELATÓRIO FINAL ---");
                System.out.println("Produtos diferentes: " + contadorProdutosDiferentes);
                System.out.println("Total de itens físicos: " + totalItensEstoque);
                System.out.printf("Valor total do patrimônio: R$ %.2f\n", valorTotalEstoque);
            } else {
                System.out.println("Opçao inválida.");
            }
        }
        leitura.close();
    }
}
