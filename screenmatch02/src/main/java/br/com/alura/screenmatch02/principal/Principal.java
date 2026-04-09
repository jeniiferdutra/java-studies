package br.com.alura.screenmatch02.principal;

import br.com.alura.screenmatch02.model.DadosEpisodio;
import br.com.alura.screenmatch02.model.DadosSerie;
import br.com.alura.screenmatch02.model.DadosTemporada;
import br.com.alura.screenmatch02.model.Episodio;
import br.com.alura.screenmatch02.service.ConsumoAPI;
import br.com.alura.screenmatch02.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados(); // Instaciar o Conversor

    private final String ENDERECO = "https://omdbapi.com/?t="; // final significa que nao vai modificar ela futuramente
    private final String API_KEY = "&apikey=e5be24ea";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class); // Transformar em DadosSerie
        System.out.println(dados);

        // VISUALIZAR TODAS AS TEMPORADAS
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();// get -> pegar a temp do indice
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }

        // FORMA APRIMORADA
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        temporadas.forEach(System.out::println);
        /*
         * * Uma função anônima (sem nome) que permite escrever código de forma muito mais concisa. Em vez de criar um método inteiro, você define a lógicav diretamente onde ela será usada. Estrutura: (parâmetros) -> { corpo da função } Exemplo acima: 's' é o parâmetro (cada item da lista) e
         */

//        System.out.println("------------------------");
//        System.out.println("Fluxo de dados com Stream");
//        List<String> nomes = Arrays.asList("Jenifer", "Jaqueline", "Iasmin");
//        nomes.stream()
//                .sorted() // ordem alfabética (A-Z), ordem crescente (1, 2, 3...).
//                .limit(2)
//                .forEach(System.out::println);

//        System.out.println("\nTop 10 episódios");
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()) // gerar um fluxo de dados com os eps de todas as temporadas
//                .collect(Collectors.toList()); // coletar tudo para uma nova lista, lista mutavel
//                //.toList(); -> lista imutavel
//        System.out.println();
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                //Visualizar cada etapa do que esta sendo feito nas operacoes encadeadas
//                .peek(e -> System.out.println("Primeiro filtro N/A " + e))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())// decrescente
//                .peek(e -> System.out.println("Ordenacao " + e))
//                .limit(10)
//                .peek(e -> System.out.println("Limite " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Mapeamento " + e))
//                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());
        episodios.forEach(System.out::println);

        System.out.println("Digite um trecho do título do episódio");
        var trechoTitulo = leitura.nextLine();

        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();
        if(episodioBuscado.isPresent()) { // se existe
            System.out.println("Episódio encontrado!");
            System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
        } else {
            System.out.println("Episódio nao encontrado!");
        }
//
//        System.out.println("A partir de que ano voce deseja ver os episódios?");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");// formatar para o padrao brasileiro
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episódio: " + e.getTitulo() +
//                                " Data de lançamento: " + e.getDataLancamento().format(formatador)
//                ));
    }
}
