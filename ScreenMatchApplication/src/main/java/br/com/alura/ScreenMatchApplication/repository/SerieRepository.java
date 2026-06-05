package br.com.alura.ScreenMatchApplication.repository;

// Repository -> vai fazer operaçoes básicas do CRUD

import br.com.alura.ScreenMatchApplication.model.Categoria;
import br.com.alura.ScreenMatchApplication.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    //Buscar por trecho do título (pode ser que ache ou nao)
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    // Buscar por ator e add mais um critério que é avaliaçao (maior ou igual a 8.8)
    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);
}
