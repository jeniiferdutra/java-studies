package com.br.gerenciador.pedidos.gerenciador_pedidos.repository;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeIgnoreCase(String nome);
}
