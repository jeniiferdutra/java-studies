package br.com.alura;

public class Push extends Notificacao{
    private String titulo;

    public Push(String destinatario, String titulo, String mensagem) {
        super(destinatario, mensagem);
        this.titulo = titulo;
    }

    @Override
    public void enviar() {
        System.out.printf("\nEnviando Push para: %s", destinatario);
        System.out.printf("\nNovidade!: %s", titulo);
        System.out.printf("\nConteúdo: %s", mensagem);
    }
}
