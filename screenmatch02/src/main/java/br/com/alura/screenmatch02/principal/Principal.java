package br.com.alura.screenmatch02.principal;

import br.com.alura.screenmatch02.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    private final String ENDERECO = "https://omdbapi.com/?t= "; // final significa que nao vai modificar ela futuramente
    private final String API_KEY = "&apikey=e5be24ea";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

    }
}
