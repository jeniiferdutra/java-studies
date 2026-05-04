package br.com.alura.ScreenMatchApplication.service;

import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        // Ler o json e tenta transformar na classe que a pessoa passou
        return mapper.readValue(json, classe); // similar ao gson
    }
}

