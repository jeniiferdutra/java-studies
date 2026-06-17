package com.br.jenifer.fipeapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        @JsonAlias("codigo") String codigo,
        @JsonAlias("nome") String descricao
) {
    @Override
    public String toString() {
        return String.format(
                "| Cód: %s | Descriçao: %s",
                codigo, descricao
        );
    }

}
