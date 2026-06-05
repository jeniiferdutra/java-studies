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

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private PedidoRepository pedidoRepository;

    public Main(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void salvarDados() {
        Categoria categoria01 = new Categoria("Kindle");
        Categoria categoria02 = new Categoria("Papelaria");
        Categoria categoria03 = new Categoria("Livros");


        Produto produto01 = new Produto("Kindle - 11 geracao", 550.0);
        Produto produto02 = new Produto("Chancela", 140.0);
        Produto produto03 = new Produto("Outlander", 65.0);

        categoria01.setProdutos(List.of(produto01));
        categoria02.setProdutos(List.of(produto02));
        categoria03.setProdutos(List.of(produto03));

        Pedido pedido01 = new Pedido(LocalDate.now());
        Pedido pedido02 = new Pedido(LocalDate.of(2026, 5, 20));
        Pedido pedido03 = new Pedido(LocalDate.of(2012, 1, 24));

        categoriaRepository.saveAll(List.of(categoria01, categoria02, categoria03));

        pedidoRepository.saveAll(List.of(pedido01, pedido02, pedido03));
    }
}
