package br.com.alura.ScreenMatchApplication.controller;

import br.com.alura.ScreenMatchApplication.dto.SerieDTO;
import br.com.alura.ScreenMatchApplication.model.Serie;
import br.com.alura.ScreenMatchApplication.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    // Método vai responder a requisições do tipo HTTP GET
    @GetMapping("/series")
    public List<SerieDTO> obterSeries() {
        return repository.findAll()
                .stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }
}
