package br.com.alura;

public class CartaoCredito extends Pagamento{
    public CartaoCredito(double valor) {
        super(valor);
    }

    @Override
    public void confirmarPagamento() {
        System.out.printf("\nPagamento de R$%.2f confirmardo no Cartao de Crédito (Taxa: R$%.2f)", valor, calcularTaxa());
    }

    @Override
    public double calcularTaxa() {
        return valor * 0.03;
    }
}
