package br.com.alura.ScreenMatchApplication.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient(); // cliente
        HttpRequest request = HttpRequest.newBuilder() // criar uma uri para dizer pra qual endereco eu vou fazer requisicao
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client // tentar receber a resposta
                    .send(request, HttpResponse.BodyHandlers.ofString()); // cliente vai mandar a requisicao e receber essa resposta
        } catch (IOException e) { // tratamento de exception pq pode acontecer algum erro (end errado, etc)
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body(); // devolver o corpo da resposta
        return json;
    }
}

