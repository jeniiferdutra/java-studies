package br.com.alura;

public class BoletoBancario extends Pagamento{
    public BoletoBancario(double valor) {
        super(valor);
    }

    @Override
    public void confirmarPagamento() {
        System.out.printf("\nBoleto de R$%.2f  gerado com sucesso (Taxa: R$%.2f)", valor, calcularTaxa());
    }

    @Override
    public double calcularTaxa() {
        return valor * 0.1;
    }
}
