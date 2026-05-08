package br.com.alura.ScreenMatchApplication.repository;

// Repository -> vai fazer operaçoes básicas do CRUD

import br.com.alura.ScreenMatchApplication.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
