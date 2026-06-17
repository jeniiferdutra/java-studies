package com.br.gerenciador.pedidos.gerenciador_pedidos.repository;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto>findByNomeIgnoreCase(String nome);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByPrecoLessThan(double preco);

    List<Produto> findByCategoriaNomeIgnoreCaseOrderByPrecoAsc(String nomeCategoria);

    List<Produto> findByCategoriaNomeIgnoreCaseOrderByPrecoDesc(String nomeCategoria);

    long countByCategoriaNomeIgnoreCase(String nomeCategoria);

    // JPQL
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> buscarPorPrecoMaior(@Param("preco") Double preco);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> buscarOrdenadoPorPrecoAsc(String nomeCategoria);

    @Query("SELECT p FROM Produto p ORDER BY p.nome DESC")
    List<Produto> buscarOrdenadoPorNomeDesc(String nomeCategoria);
}
