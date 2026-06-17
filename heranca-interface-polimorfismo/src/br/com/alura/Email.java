package br.com.alura;

public class Email extends Notificacao{
    private String assunto;

    public Email(String destinatario, String assunto, String mensagem) {
        super(destinatario, mensagem);
        this.assunto = assunto;
    }

    @Override
    public void enviar() {
        System.out.printf("\nEnviando Email para: %s", destinatario);
        System.out.printf("\nAssunto: %s", assunto);
        System.out.printf("\nCorpo: %s", mensagem);
    }
}
