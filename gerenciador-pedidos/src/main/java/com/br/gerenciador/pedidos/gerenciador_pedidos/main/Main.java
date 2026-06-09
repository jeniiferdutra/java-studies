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
                    5 - Buscar produtos por categoria (Preço Crescente)
                    6 - Buscar produtos por categoria (Preço Decrescente)
                    7 - Contar produtos por categoria
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
                    buscarProdutosPorCategoriaOrdenadosPorPrecoCrescente();
                    break;
                case 6:
                    buscarProdutosPorCategoriaOrdenadosPorPrecoDecrescente();
                    break;
                case 7:
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
        System.out.println("Digite um valor:");
        var valor = leitura.nextDouble();
        leitura.nextLine();
        List<Produto> filtroValor = produtoRepository.findByPrecoGreaterThan(valor);
        System.out.println("Produtos achados a partir desse valor:");
        filtroValor.forEach(p ->
                System.out.println(p.getNome() + " | Preço: R$ " + p.getPreco()));
    }

    private void buscarProdutosComPrecoMenorQue() {
        System.out.println("Digite um valor:");
        var valor = leitura.nextDouble();
        leitura.nextLine();
        List<Produto> filtroValor = produtoRepository.findByPrecoLessThan(valor);
        System.out.println("Produtos achados a partir desse valor:");
        filtroValor.forEach(p ->
                System.out.println(p.getNome() + " | Preço: R$ " + p.getPreco()));
    }

    private void buscarProdutosPorCategoriaOrdenadosPorPrecoCrescente() {
        System.out.println("Digite o nome da respectiva categoria:");
        var nomeCategoria = leitura.nextLine();
        List<Produto> produtosOrdenados = produtoRepository.findByCategoriaNomeIgnoreCaseOrderByPrecoAsc(nomeCategoria);

        System.out.println("Produtos da categoria '" + nomeCategoria + "' (Do mais barato ao mais caro):");
        if (produtosOrdenados.isEmpty()) {
            System.out.println("Nenhum produto encontrado para essa categoria.");
        } else {
            produtosOrdenados.forEach(c ->
                    System.out.println(c.getNome() + " | Preço: R$ " + c.getPreco()));
        }
    }

    private void buscarProdutosPorCategoriaOrdenadosPorPrecoDecrescente() {
    }

    private void contarProdutosPorCategoria() {
    }

}
