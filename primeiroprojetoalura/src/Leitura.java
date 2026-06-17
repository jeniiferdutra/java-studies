import java.util.Scanner; // Importa a biblioteca para ler entradas

public class Leitura {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);// "System.in" indica que a fonte de dados é o teclado

        System.out.println("Digite seu filme favorito");
        String filme = leitura.nextLine();// nextLine() lê a linha inteira (incluindo espaços) até você apertar Enter
        System.out.println("Ano de lançamento?");
        int anoDeLancamento = leitura.nextInt(); // Espera um tipo inteiro
        System.out.println("Diga sua avaliaçao para o filme");
        double avaliacaoFulme = leitura.nextDouble();
        System.out.println("Nome do filme preferido: " + filme + ", Ano de lançamento: " + anoDeLancamento + ", Avaliaçao do filme: " + avaliacaoFulme);
    }
}