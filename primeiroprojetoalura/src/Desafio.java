import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        System.out.println("************************************");

        System.out.println("Dados iniciais do cliente: ");

        String nome = "Jenifer Rocha Dutra";
        System.out.println("Nome: " + nome);
        String tipoConta = "Corrente";
        System.out.println("Tipo de conta: " + tipoConta);
        double saldoConta = 60000;
        System.out.println("Saldo inicial: R$ " + saldoConta);

        System.out.println("************************************");

        System.out.println("Operaçoes");

        Scanner leitura = new Scanner(System.in);

        int opcao = leitura.nextInt();

        while (opcao != 4) {

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

            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Receber valor");
            System.out.println("3 - Transferir valor");
            System.out.println("4 - Sair");

            System.out.println("Digite a opção desejada: ");
            leitura.nextInt();
        }
    }
}
