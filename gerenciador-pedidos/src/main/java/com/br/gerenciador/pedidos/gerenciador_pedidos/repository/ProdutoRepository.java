package com.br.gerenciador.pedidos.gerenciador_pedidos.repository;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto>findByNomeIgnoreCase(String nome);
}
