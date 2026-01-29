public class Filme { // TODO FILME TEM UM NOME
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    // Este método É void. Ele apenas imprime algo na tela.
    void exibeFichaTecnica()  {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++; // incrementa
    }

    double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
