package br.com.alura.ScreenMatchApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

    // Método vai responder a requisições do tipo HTTP GET
    @GetMapping("/series")
    public String obterSeries() {
        return "Aqui vão ser listadas as séries";
    }
}
