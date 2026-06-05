package br.com.alura.ScreenMatchApplication.repository;

// Repository -> vai fazer operaçoes básicas do CRUD

import br.com.alura.ScreenMatchApplication.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    //Buscar por trecho do título (pode ser que ache ou nao)
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
}
