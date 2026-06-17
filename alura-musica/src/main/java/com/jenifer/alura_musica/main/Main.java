package com.jenifer.alura_musica.main;

import com.jenifer.alura_musica.model.Artista;
import com.jenifer.alura_musica.model.Musica;
import com.jenifer.alura_musica.model.TipoArtista;
import com.jenifer.alura_musica.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final ArtistaRepository repository;

    Scanner leitura = new Scanner(System.in);

    public Main(ArtistaRepository repository) {
        this.repository = repository;
    }

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
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista:");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repository.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }

    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar música de que artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repository.findByNomeArtistaContainingIgnoreCase(nome);
        if(artista.isPresent()) {
            System.out.println("Informe o tipo da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get()); // musica pertence a um determinado artista
            artista.get().getMusicas().add(musica); // salvar a musica do artista no banco
            repository.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
        
    }

    private void listarMusicas() {
        List<Artista> artistas = repository.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void dadosSobreUmArtista() {
    }


}
