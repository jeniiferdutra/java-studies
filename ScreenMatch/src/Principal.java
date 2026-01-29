//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.nome = "Vanilla Sky";
        meuFilme.anoDeLancamento = 2001;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(5);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        System.out.println("Soma das avaliacoes: " + meuFilme.somaDasAvaliacoes);
        System.out.println("Total de avaliacoes: " + meuFilme.totalDeAvaliacoes);
        System.out.println("Média de avaliacoes: " + meuFilme.pegaMedia());

        Calculadora calculadora = new Calculadora();

        int meuResultado = calculadora.dobrar(3); // Armazenei o 6 aqui
        System.out.println("O dobro do numero é " + meuResultado);

        Musica musica = new Musica();

        musica.titulo = "O silencio das estrelas";
        musica.artista = "Lenine";
        musica.anoLancamento = 2003;
        musica.fichaTecnica();
        System.out.println(musica);

        musica.avalia(10);
        musica.avalia(9.9);
        musica.avalia(10);
        musica.avalia(8.5);
        System.out.println("Soma das avaliacoes: " + musica.somaAvaliacao);
        System.out.println("Total de avaliacoes: " + musica.numAvaliacoes);
        System.out.println("Média de avaliacoes: " + musica.calculaMedia());
    }
}