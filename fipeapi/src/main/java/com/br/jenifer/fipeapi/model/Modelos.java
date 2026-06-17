package com.br.jenifer.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<Veiculo> modelos) {
}
