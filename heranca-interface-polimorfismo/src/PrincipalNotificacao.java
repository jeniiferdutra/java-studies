import br.com.alura.Email;
import br.com.alura.Push;
import br.com.alura.SMS;

public class PrincipalNotificacao {
    public static void main(String[] args) {

        Email email = new Email("cliente@exemplo.com",
                "Promoção especial!",
                "Aproveite nossos descontos esta semana.");

        SMS sms = new SMS("(11) 98765-4321",
                "Sua fatura foi paga com sucesso.");

        Push push = new Push("usuario_app",
                "Novidade!",
                "Você tem uma nova mensagem não lida.");

        email.enviar();
        sms.enviar();
        push.enviar();
    }

}
