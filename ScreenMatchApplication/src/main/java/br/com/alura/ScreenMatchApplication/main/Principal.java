package br.com.alura.ScreenMatchApplication.main;

import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);



    public void exibeMenu() {
        var menu = """
                1 - Buscar séries
                2 - Buscar episódios
                0 - Sair
                """;

        System.out.println(menu);
        var opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao) {
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    public void buscarSerieWeb(){

    }

    public void buscarEpisodioPorSerie() {

    }
}
