package com.jenifer.alura_musica.repository;

import com.jenifer.alura_musica.model.Artista;
import com.jenifer.alura_musica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nome);

    //JPQL
    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nomeArtista ILIKE %:nomeArtista%")
    List<Musica> buscaMusicasPorArtista(String nomeArtista);
}
