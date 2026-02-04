import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

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

        ModeloCarro modeloCarro = new ModeloCarro();

        modeloCarro.setNomeModelo("IX35");
        modeloCarro.setPrecoAno1(54000);
        modeloCarro.setPrecoAno2(60000);
        modeloCarro.setPrecoAno3(65000);
        modeloCarro.calcularMedia();
        modeloCarro.calcularMaiorPreco();
        modeloCarro.calcularMenorPreco();
        System.out.println("O nome do modelo do carro é: " + modeloCarro.getNomeModelo());
        System.out.println("A média do valor do carro é: R$" + modeloCarro.calcularMedia());
        System.out.println("O menor valor é: R$ " + modeloCarro.calcularMenorPreco());
        System.out.println("O maior valor é: R$ " + modeloCarro.calcularMaiorPreco());

        Animal animal = new Animal();
        animal.emitirSom();

        Cachorro cachorro = new Cachorro();
        cachorro.abanarRabo();
        System.out.println(cachorro.abanarRabo());

        Gato gato = new Gato();
        System.out.println(gato.arranharMoveis());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new  Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        ConversorMoeda converte = new ConversorMoeda();
        converte.setDolar(100);
        System.out.println("O valor convertido em reais é R$ " + converte.converterDolarParaReal());

        CalculadoraSalaRetangular sala = new CalculadoraSalaRetangular();
        sala.setAltura(8.9);
        sala.setLargura(20);
        sala.calcularArea();
        sala.calcularPerimetro();

        System.out.println("A area total é: " + sala.calcularArea());
        System.out.println("O perimetro é: " + sala.calcularPerimetro());

        TabuadaMultiplicacao tabuada = new TabuadaMultiplicacao();
        tabuada.setNumero(2);
        System.out.println(tabuada.mostrarTabuada());
    }
}