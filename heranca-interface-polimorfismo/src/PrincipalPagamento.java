import br.com.alura.BoletoBancario;
import br.com.alura.CartaoCredito;
import br.com.alura.Pagamento;
import br.com.alura.Pix;

public class PrincipalPagamento {
    public static void main(String[] args) {

        Pagamento credito = new CartaoCredito(250.00);
        Pagamento boleto = new BoletoBancario(500.00);
        Pagamento pix = new Pix(300.00);

        credito.confirmarPagamento();
        boleto.confirmarPagamento();
        pix.confirmarPagamento();
    }
}
