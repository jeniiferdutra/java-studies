public class Conta {
    double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void exibirSaldo() {
        System.out.printf("\nSálario: R$ %.2f", saldo);
    }

    public void zerarSaldo() {
        saldo = 0;
        System.out.printf("\nSálario atualizado: R$ %.2f", saldo);
    }
}
