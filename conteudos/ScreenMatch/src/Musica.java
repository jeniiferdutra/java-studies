public class Musica {
    String titulo;
    String artista;
    int anoLancamento;
    double somaAvaliacao;
    int numAvaliacoes;

    void fichaTecnica() {
        System.out.println("Título: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Ano de lancamento: " + anoLancamento);
        System.out.println("Numero de avaliacoes: " + numAvaliacoes);
    }

    void avalia(double nota) {
        somaAvaliacao += nota;
        numAvaliacoes++;
    }

    double calculaMedia() {
        return somaAvaliacao / numAvaliacoes;
    }
}
