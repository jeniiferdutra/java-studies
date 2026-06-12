package br.com.alura.ScreenMatchApplication.main;

import br.com.alura.ScreenMatchApplication.model.*;
import br.com.alura.ScreenMatchApplication.repository.SerieRepository;
import br.com.alura.ScreenMatchApplication.service.ConsumoAPI;
import br.com.alura.ScreenMatchApplication.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Principal {
    Scanner leitura = new Scanner(System.in);

    private ConsumoAPI consumo = new ConsumoAPI();

    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://omdbapi.com/?t=";

    private final String API_KEY = "&apikey=e5be24ea";

    private List <DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository repositorio;

    private List<Serie> series = new ArrayList<>();

    private Optional<Serie> serieBusca;

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries buscadas
                    4 - Buscar série por título
                    5 - Buscar séries por ator
                    6 - Top 5 Séries
                    7 - Buscar séries por categoria
                    8 - Buscar series por numero máximo de temporadas
                    9 - Buscar episódio por trecho
                    10 - Top 5 episódios por série
                    11 - Buscar episódios a partir de uma data
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriesPorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    filtrarSeriesPorTemporadaEAvaliacao();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    topEpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosDepoisDeUmaData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        }
    }

    public void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        repositorio.save(serie);// Salvar no repositório
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscadas(); // Mostra na tela as séries que o usuário já tem salvas no banco
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = leitura.nextLine();

        // Procura na lista local de séries se o nome digitado bate com algum título
        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie); // método mais efetivo

//                series.stream()
//                // Filtra ignorando letras maiúsculas/minúsculas
//                .filter(s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase()))
//                // Pega o primeiro resultado que encontrar (se houver)
//                .findFirst();

        if(serie.isPresent()) { // Se a serie estiver presente

            // Pega o objeto real da Série que estava guardado dentro do Optional
            var serieEcontrada = serie.get(); // ter a referencia da serie
            List<DadosTemporada> temporadas = new ArrayList<>();

            // Loop "for" para ir de 1 até o total de temporadas da série (ex: de 1 a 5)
            for (int i = 1; i <= serieEcontrada.getTotalTemporadas(); i++) {
                // // Faz a chamada na API do OMDB para buscar a temporada atual (i)
                var json = consumo.obterDados(ENDERECO + serieEcontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                // Converte o JSON daquela temporada específica para o nosso Record DadosTemporada
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                // Guarda essa temporada convertida na nossa lista
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            // Transforma os dados da API em entidades do Banco de Dados
            List<Episodio> episodios = temporadas.stream()
                    // flatMap: "achata" as listas de episódios de cada temporada em um único fluxo (Stream)
                    .flatMap(d -> d.episodios().stream()
                            // map: Transforma cada "DadosEpisodio" (Record) em um "Episodio" (Classe/@Entity)
                            .map(e -> new Episodio(d.numero(), e)))
                    // Junta todos esses novos episódios em uma lista final
                    .collect(Collectors.toList());

            // Vincula essa lista de episódios nova à série que encontramos lá no início
            serieEcontrada.setEpisodios(episodios);
            repositorio.save(serieEcontrada);
        } else {
            System.out.println("Serie nao encontrada");
        }
    }

    private void listarSeriesBuscadas() {
        series = repositorio.findAll(); // ir no repositório e retornar todos que estao cadastrados
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = leitura.nextLine();
         serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if(serieBusca.isPresent()) {
            System.out.println("Dados da série: " + serieBusca.get());
        } else {
            System.out.println("Série nao encontrada");
        }
    }

    private void buscarSeriesPorAtor() {
        System.out.println("Qual o nome para busca:");
        var nomeAtor = leitura.nextLine();
        System.out.println("Avaliaçoes a partir de qual valor: ");
        var avaliacao = leitura.nextDouble();
        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);
        System.out.println("Séries em que " + nomeAtor + " trabalhou:");
        seriesEncontradas.forEach(s ->
                System.out.println(s.getTitulo() + " avaliaçao: " + s.getAvaliacao()));
    }

    private void buscarTop5Series() {
        List<Serie> seriesTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
        seriesTop.forEach(s ->
                System.out.println(s.getTitulo() + " avaliaçao: " + s.getAvaliacao()));
    }

    private void buscarSeriesPorCategoria() {
        System.out.println("Deseja buscar séries de que categoria/genero?");
        var nomeGenero = leitura.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Séries da categoria " + nomeGenero);
        seriesPorCategoria.forEach(System.out::println);
    }

    private void filtrarSeriesPorTemporadaEAvaliacao() {
        System.out.println("Filtrar séries até quantas temporadas? ");
        var maximoTemporadas = leitura.nextInt();
        leitura.nextLine();
        System.out.println("Avaliação a partir de qual valor: ");
        var avaliacao = leitura.nextDouble();
        leitura.nextLine();
        List<Serie> filtroSeries = repositorio.seriesPorTemporadaEAvaliacao(maximoTemporadas, avaliacao);
        System.out.println("Séries encontradas com " + maximoTemporadas + " temporadas e avaliação de " + avaliacao);
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + " | avaliação: " + s.getAvaliacao()));
    }

    private void buscarEpisodioPorTrecho() {
        System.out.println("Qual o nome do episódio para busca?");
        var trechoEpisodio = leitura.nextLine();
        List<Episodio> episodiosEncontrados = repositorio.episodiosPorTrecho(trechoEpisodio);
        episodiosEncontrados.forEach(e ->
                        System.out.printf("Série: %s Temporada %s - Episódio %s - %s Avaliação %s\n",
                                e.getSerie().getTitulo(),
                                e.getTemporada(),
                                e.getNumeroEpisodio(),
                                e.getTitulo(),
                                e.getAvaliacao()));
    }

    private void topEpisodiosPorSerie() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()) {
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(e ->
                    System.out.printf("Série: %s | Temporada %s | Episódio %s | %s Avaliação %s\n",
                            e.getSerie().getTitulo(),
                            e.getTemporada(),
                            e.getNumeroEpisodio(),
                            e.getTitulo(),
                            e.getAvaliacao()));
        }
    }

    private void buscarEpisodiosDepoisDeUmaData() {
        buscarSeriePorTitulo();
        if(serieBusca.isPresent()) {
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de lançamento");
            var anoLancamento = leitura.nextInt();
            leitura.nextLine();

            List<Episodio> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(System.out::println);
        }
    }
}
