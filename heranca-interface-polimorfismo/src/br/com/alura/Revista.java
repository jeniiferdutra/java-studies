package br.com.alura;

public class Revista extends Midia {
    private String edicao;

    public Revista(String titulo, int anoPublicacao, String edicao) {
        super(titulo, anoPublicacao);
        this.edicao = edicao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void exibirInfo() {
        System.out.println("Código: " + gerarCodigo() + " | Revista: \"" + getTitulo() + "\" - Ediçao: " + edicao);
    }
}
