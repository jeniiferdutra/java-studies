package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TitulosOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Gson gson = new GsonBuilder() // Configura o Gson para converter campos do JSON que começam com letra maiúscula (ex: "Title") para o padrão do Java (camelCase), e então transforma o JSON no objeto meuTituloOmdb
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TitulosOmdb  meuTituloOmdb = gson.fromJson(json, TitulosOmdb.class);
        System.out.println(meuTituloOmdb);
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        System.out.println("Titulo convertido");
        System.out.println(meuTitulo);
    }
}
