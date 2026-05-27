package br.com.alura.ScreenMatchApplication.main;

import br.com.alura.ScreenMatchApplication.model.DadosSerie;
import br.com.alura.ScreenMatchApplication.model.DadosTemporada;
import br.com.alura.ScreenMatchApplication.model.Episodio;
import br.com.alura.ScreenMatchApplication.model.Serie;
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
        listarSeriesBuscadas();
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase()))
                .findFirst();

        if(serie.isPresent()) { // Se a serie estiver presente

            var serieEcontrada = serie.get(); // ter a referencia da serie
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEcontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEcontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());

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
}
