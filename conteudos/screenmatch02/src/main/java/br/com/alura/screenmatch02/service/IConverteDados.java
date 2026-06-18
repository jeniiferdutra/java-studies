package br.com.alura.screenmatch02.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class <T> classe);

        //Vai receber um json, uma classe e no ConverteDados vai transformar esse json na classe que foi indicada
}
