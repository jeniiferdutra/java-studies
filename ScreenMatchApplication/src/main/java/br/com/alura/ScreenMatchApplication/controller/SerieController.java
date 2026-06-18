package br.com.alura.ScreenMatchApplication.controller;

import br.com.alura.ScreenMatchApplication.model.Serie;
import br.com.alura.ScreenMatchApplication.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    // Método vai responder a requisições do tipo HTTP GET
    @GetMapping("/series")
    public List<Serie> obterSeries() {
        return repository.findAll();
    }
}
