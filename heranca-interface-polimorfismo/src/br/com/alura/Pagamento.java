package br.com.alura;

public class Pagamento {
    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public void confirmarPagamento() {
    }

    public double calcularTaxa() {
        return valor * 0.0;
    }
}
