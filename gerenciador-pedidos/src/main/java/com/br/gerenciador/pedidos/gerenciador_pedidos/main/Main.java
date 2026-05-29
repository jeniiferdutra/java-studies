package com.br.gerenciador.pedidos.gerenciador_pedidos.main;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Categoria;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Pedido;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Produto;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.CategoriaRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.PedidoRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private CategoriaRepository categoriaRepository;
    private PedidoRepository pedidoRepository;
    private ProdutoRepository produtoRepository;

    public Main(CategoriaRepository categoriaRepository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public void salvarDados() {

        Categoria categoriaEletronicos = new Categoria(null, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(null, "Livros");

        Produto produto1 = new Produto("Smartphone", 1500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros);

        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
        categoriaLivros.setProdutos(List.of(produto3, produto4));

        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

//        produtoRepository.save(produto);
//        categoriaRepository.save(categoria);
//        pedidoRepository.save(pedido);

        // Testando a persistência e o relacionamento
        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });

    }
}
