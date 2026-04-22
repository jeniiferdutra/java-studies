package com.br.jenifer.fipeapi.main;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {
    private final Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibirMenu() {
        var opcao = "";

        while (!opcao.equalsIgnoreCase("sair")) {
            exibirOpcoes();
            opcao = leitura.nextLine().toLowerCase();

            if (opcao.contains("carr")) {
                carros();
            } else if (opcao.contains("mot")) {
                motos();
            } else if (opcao.contains("cami")) {
                caminhoes();
            } else if (!opcao.equalsIgnoreCase("sair")) {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void exibirOpcoes() {
        System.out.println("""
                \n*** OPÇÕES ***
                Carro
                Moto
                Caminhão
                
                Digite 'sair' para encerrar.
                """);
    }

    public void carros() {
        System.out.println("Buscando marcas de carros...");
        // Lógica para acessar ENDERECO + "carros/marcas"
    }

    public void motos() {
        System.out.println("Buscando marcas de motos...");
    }

    public void caminhoes() {
        System.out.println("Buscando marcas de caminhões...");
    }
}