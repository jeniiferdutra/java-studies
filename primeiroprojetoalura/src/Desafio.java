import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {

        String nome = "Jenifer Rocha Dutra";
        String tipoConta = "Corrente";
        double saldoConta = 60000;
        int opcao = 0;

        System.out.println("************************************");
        System.out.println("\nDados iniciais do cliente: ");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Saldo inicial: R$ " + saldoConta);
        System.out.println("\n************************************");

        System.out.println("Operaçoes");

        String menu = """
                *** Digite sua opçao ***
                1 - Consultar saldo
                2 - Transferir saldo
                3 - Receber valor
                4 - Sair
                """;
        Scanner leitura = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

        switch (opcao) {
                case 1:
                    System.out.println("R$ " + saldoConta);
                    break;
                case 2:
                    System.out.println("Informe o valor a receber: ");
                    double valorAReceber = leitura.nextDouble();
                    saldoConta += valorAReceber;
                    System.out.println("Saldo atualizado: R$ " + saldoConta);
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir: ");
                    double valorTransferido = leitura.nextDouble();
                    if (valorTransferido > saldoConta) {
                        System.out.println("Nao ha saldo suficiente para fazer essa transferencia.");
                    } else {
                        saldoConta -= valorTransferido;
                        System.out.println("Saldo atualizado: R$ " + saldoConta);
                    }
                    break;
                default:
                    System.out.println("Opçao inválida");
                    break;
            }
        }
    }
}
