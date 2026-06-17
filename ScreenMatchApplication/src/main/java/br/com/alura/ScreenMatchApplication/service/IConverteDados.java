package br.com.alura.ScreenMatchApplication.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class <T> classe);
}
