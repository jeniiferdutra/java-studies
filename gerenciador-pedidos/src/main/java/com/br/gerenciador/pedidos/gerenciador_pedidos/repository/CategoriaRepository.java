package com.br.gerenciador.pedidos.gerenciador_pedidos.repository;

import com.br.gerenciador.pedidos.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNomeIgnoreCase(String nome);
}
