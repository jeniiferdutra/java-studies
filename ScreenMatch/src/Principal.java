import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("Vanilla Sky");
        meuFilme.setAnoDeLancamento(2001);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Durarçao do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(5);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        System.out.println("Total de avaliacoes: " + meuFilme.getTotalDeAvaliacoes());
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

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2001);
        lost.exibeFichaTecnica();
        lost.setTemporadas(7);
        lost.setEpisodiosPorTemporada(21);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duraçao para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();
        outroFilme.setNome("The Profissional");
        outroFilme.setAnoDeLancamento(1998);
        outroFilme.setDuracaoEmMinutos(160);

        CalculadoraDeTempo calculaTempo = new CalculadoraDeTempo();
        calculaTempo.inclui(meuFilme);
        calculaTempo.inclui(outroFilme);
        calculaTempo.inclui(lost);
        System.out.println(calculaTempo.getTempoTotal());


    }
}