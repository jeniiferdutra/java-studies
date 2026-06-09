package com.br.gerenciador.pedidos.gerenciador_pedidos.main;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Categoria;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Pedido;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Produto;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.CategoriaRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.PedidoRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.ProdutoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    Scanner leitura = new Scanner(System.in);

    List<Produto> produto = new ArrayList<>();

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private PedidoRepository pedidoRepository;

    public Main(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar produto
                    2 - Buscar produtos por categoria
                    3 - Buscar produtos com preço maior que
                    4 - Buscar produtos com preço menor que
                    5 - Buscar produtos por trecho do nome
                    6 - Buscar produtos por categoria (Preço Crescente)
                    7 - Buscar produtos por categoria (Preço Decrescente)
                    8 - Contar produtos por categoria
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarProdutos();
                    break;
                case 2:
                    buscarProdutosPorNomeDaCategoria();
                    break;
                case 3:
                    buscarProdutosComPrecoMaiorQue();
                    break;
                case 4:
                    buscarProdutosComPrecoMenorQue();
                    break;
                case 5:
                    buscarProdutosPorTrechoDoNome();
                    break;
                case 6:
                    buscarProdutosPorCategoriaOrdenadosPorPrecoCrescente();
                    break;
                case 7:
                    buscarProdutosPorCategoriaOrdenadosPorPrecoDecrescente();
                    break;
                case 8:
                    contarProdutosPorCategoria();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        }
    }

    private void buscarProdutos() {
        System.out.println("Digite o nome do produto:");
        var nomeProduto = leitura.nextLine();
        List<Produto> produtoEncontrado = produtoRepository.findByNomeIgnoreCase(nomeProduto);
        System.out.println("Resultado da pesquisa:");
        produtoEncontrado.forEach(p ->
                System.out.println(p.getNome() + " | Preço: R$ " + p.getPreco()));
    }

    private void buscarProdutosPorNomeDaCategoria() {
        System.out.println("Digite uma categoria:");
        var categoria = leitura.nextLine();
        Optional<Categoria> categorias = categoriaRepository.findByNomeIgnoreCase(categoria);
        System.out.println("Resultado da pesquisa:");
        if (categorias.isPresent()) {
            // Se achou a categoria, pega a lista de produtos de dentro dela!
            List<Produto> produtos = categorias.get().getProdutos();
            produtos.forEach(p ->
                    System.out.println(p.getNome() + " | Preço: R$ " + p.getPreco()));
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }

    private void buscarProdutosComPrecoMaiorQue() {
    }

    private void buscarProdutosComPrecoMenorQue() {
    }

    private void buscarProdutosPorTrechoDoNome() {
    }

    private void buscarProdutosPorCategoriaOrdenadosPorPrecoCrescente() {
    }

    private void buscarProdutosPorCategoriaOrdenadosPorPrecoDecrescente() {
    }

    private void contarProdutosPorCategoria() {
    }

//    public void salvarDados() {
//        Categoria categoria01 = new Categoria("Kindle");
//        Categoria categoria02 = new Categoria("Papelaria");
//        Categoria categoria03 = new Categoria("Livros");
//
//
//        Produto produto01 = new Produto("Kindle - 10 geração", 550.0);
//        Produto produto02 = new Produto("Chancela", 140.0);
//        Produto produto03 = new Produto("Outlander", 65.0);
//        Produto produto04 = new Produto("O ultimo reino", 52.0);
//        Produto produto05 = new Produto("Tetralogia Napolitana", 165.0);
//        Produto produto06 = new Produto("Slewfoot", 70.0);
//        Produto produto07 = new Produto("Pachinko", 67.0);
//        Produto produto08 = new Produto( "Carimbo de cera", 25.0);
//        Produto produto09 = new Produto("Pistola cola quente", 15.0);
//        Produto produto10 = new Produto("10 peças de envelope para carta", 30.90);
//        Produto produto11 = new Produto("Bastão vermelho de cera", 18.0);
//        Produto produto12 = new Produto("Kindle Colorsoft", 1400.0);
//        Produto produto13 = new Produto("Kindle Paperwhite", 880.0);
//
//        categoria01.setProdutos(List.of(produto01, produto12, produto13));
//        categoria02.setProdutos(List.of(produto02, produto08, produto09, produto10, produto11));
//        categoria03.setProdutos(List.of(produto03, produto04, produto05, produto06, produto07));
//
//        Pedido pedido01 = new Pedido(LocalDate.now());
//        Pedido pedido02 = new Pedido(LocalDate.of(2026, 5, 20));
//        Pedido pedido03 = new Pedido(LocalDate.of(2015, 5, 11));
//        Pedido pedido04 = new Pedido(LocalDate.of(2009, 11, 30));
//        Pedido pedido05 = new Pedido(LocalDate.of(2013, 9, 7));
//        Pedido pedido06 = new Pedido(LocalDate.of(2020, 1, 21));
//        Pedido pedido07 = new Pedido(LocalDate.of(2019, 7, 18));
//        Pedido pedido08 = new Pedido(LocalDate.of(2010, 10, 1));
//        Pedido pedido09 = new Pedido(LocalDate.of(2023, 11, 22));
//        Pedido pedido10 = new Pedido(LocalDate.of(2019, 3, 15));
//        Pedido pedido11 = new Pedido(LocalDate.of(2012, 7, 10));
//        Pedido pedido12 = new Pedido(LocalDate.of(2016, 5, 30));
//        Pedido pedido13 = new Pedido(LocalDate.of(2013, 12, 24));
//
//        categoriaRepository.saveAll(List.of(categoria01, categoria02, categoria03));
//
//        pedidoRepository.saveAll(List.of(pedido01, pedido02, pedido03, pedido04, pedido05, pedido06, pedido07, pedido08, pedido09, pedido10, pedido11, pedido12, pedido13));
//    }
}
