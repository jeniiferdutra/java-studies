package br.com.alura.screenmatch02.principal;

import br.com.alura.screenmatch02.model.DadosSerie;
import br.com.alura.screenmatch02.model.DadosTemporada;
import br.com.alura.screenmatch02.service.ConsumoAPI;
import br.com.alura.screenmatch02.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }
}
