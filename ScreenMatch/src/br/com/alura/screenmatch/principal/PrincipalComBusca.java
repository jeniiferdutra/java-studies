package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErrorDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TitulosOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        // Transformar o json na classe Titulo
        Gson gson = new GsonBuilder() // Configura o Gson para converter campos do JSON que começam com letra maiúscula (ex: "Title") para o padrão do Java (camelCase), e então transforma o JSON no objeto meuTituloOmdb
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() // deixa o formato json mais bonito
                .create();

        // equalsIgnoreCase = se digitar com letra maiuscula ou minuscula nao faz diferença
        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca:");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                break; // sai do looping
            }

            // replace - para pesquisar titulos com espaço
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=e5be24ea";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                // VISUALIZAR A DOCUMENTACAO
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                // visualizar o json
                String json = response.body();
                System.out.println(json);

                TitulosOmdb meuTituloOmdb = gson.fromJson(json, TitulosOmdb.class);
                System.out.println(meuTituloOmdb);
                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço.");// Caso de pesquisar um filme colocando espaço e der erro
            } catch (ErrorDeConversaoDeAnoException e) {
                System.out.println(e.getMensagem()); // Classe mae de todas as Exceptions, mais generico
            }
        }
        System.out.println("Programa finalizou corretamente.");

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos)); // transformando em json
        escrita.close(); // fecha o arquivo
        System.out.println(titulos);
    }
}
