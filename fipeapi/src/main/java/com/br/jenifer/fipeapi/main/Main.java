package com.br.jenifer.fipeapi.main;

import com.br.jenifer.fipeapi.service.ConsumoAPI;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Main {
    private final Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

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
    }
}