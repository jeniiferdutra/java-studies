package br.com.alura.ScreenMatchApplication.dto;

import br.com.alura.ScreenMatchApplication.model.Categoria;
// só vamos retornar dados, portanto nao estaremos preocupados com regras de negócios
public record SerieDTO(Long id,

                       String titulo,

                       Integer totalTemporadas,

                       double avaliacao,

                       Categoria genero,

                       String atores,

                       String poster,

                       String sinopse) {
}
