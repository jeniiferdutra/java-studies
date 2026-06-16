package com.jenifer.alura_musica.main;

import java.util.Scanner;

public class Main {
    Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artista
                    5 - Pesquisar dados sobre um artista
               
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    dadosSobreUmArtista();
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        }
    }

    private void cadastrarArtista() {

    }

    private void cadastrarMusica() {
        
    }

    private void listarMusicas() {
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void dadosSobreUmArtista() {
    }


}
