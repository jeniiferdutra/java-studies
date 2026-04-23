package com.br.jenifer.fipeapi.service;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JacksonException e) {
            throw new RuntimeException();        }
    }

    // Obter uma lista daquele tipo
    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) { // Vai conseguir construir uma lista genérica de dados baseado no que passar
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);

        try {
            return mapper.readValue(json, lista);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
