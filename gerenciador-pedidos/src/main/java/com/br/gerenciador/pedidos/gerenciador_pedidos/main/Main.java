package com.br.gerenciador.pedidos.gerenciador_pedidos.main;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Categoria;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Pedido;
import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Produto;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.CategoriaRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.PedidoRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.ProdutoRepository;
import java.time.LocalDate;

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

        Produto produto01 = new Produto("Kindle - 11 geracao", 550.0);
        Categoria categoria01 = new Categoria(1L, "Kindle");
        Pedido pedido01 = new Pedido(1L, LocalDate.now());

        produtoRepository.save(produto01);
        categoriaRepository.save(categoria01);
        pedidoRepository.save(pedido01);

        System.out.println("Dados salvos com sucesso!");
    }
}
