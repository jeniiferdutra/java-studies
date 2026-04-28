package com.br.jenifer.fipeapi.main;

import com.br.jenifer.fipeapi.model.Modelos;
import com.br.jenifer.fipeapi.model.Veiculo;
import com.br.jenifer.fipeapi.service.ConsumoAPI;
import com.br.jenifer.fipeapi.service.ConverteDados;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main {
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibirMenu() {
        var menu = """
                \n*** OPÇÕES ***
                Carro
                Moto
                Caminhão
                
                Digite uma das opcoes para consultar:
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else if (opcao.toLowerCase().contains("cami")) {
            endereco = URL_BASE + "caminhos/marcas";
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Veiculo.class); // me da uma lista de Veiculos
        marcas.stream()
                .sorted(Comparator.comparing(Veiculo::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta:");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca:");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Veiculo::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado:");
        var nomeVeiculo = leitura.nextLine();

        List<Veiculo> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.descricao().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliacao");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Veiculo> anos = conversor.obterLista(json, Veiculo.class);

        
    }
}