package br.com.alura.ScreenMatchApplication.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("jllBPduJ4gUNu2o4b9mQfsjLdAgb2fb2MHFOWVBxfT3BlbkFJyYVwAYIZDdMIiKG_LCYNWe7iRPuzyHt3xfCsMPjMwDkKySqUZK0t7WKZaOLpZZOMSI4DaMk1AA");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
