package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=e5be24ea";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // VISUALIZAR A DOCUMENTACAO
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        // visualizar o json
        String json = response.body();
        System.out.println(json);

        // Transformar o json na classe Titulo
        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(meuTitulo);
    }
}
