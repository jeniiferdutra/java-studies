package com.jenifer.alura_musica.repository;

import com.jenifer.alura_musica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nome);
}
