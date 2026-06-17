package br.com.alura;

public class SMS extends Notificacao{
    public SMS(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    public void enviar() {
        System.out.printf("\nEnviando SMS para: %s", destinatario);
        System.out.printf("\nMensagem: %s", mensagem);
    }
}
