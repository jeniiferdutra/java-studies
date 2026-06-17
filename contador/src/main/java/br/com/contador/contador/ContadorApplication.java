package br.com.contador.contador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class ContadorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ContadorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um número:");
        int numero = leitura.nextInt();

        for (int i = 0; i <= numero; i++) {
            System.out.println(i);
        }

        Tarefa tarefa = new Tarefa("Trabalhar", true, "Jenifer");
        ObjectMapper mapper = new ObjectMapper(); //transformar objetos Java em JSON e vice-versa
        mapper.writeValue(new File("tarefa.json"), tarefa);
        System.out.println("Arquivo tarefa.json gerado com sucesso!");

        // Desserializar
        ObjectMapper objectMapper = new ObjectMapper();
        Tarefa tarefaLida = objectMapper.readValue(new File("tarefa.json"), Tarefa.class);
        System.out.println("Tarefa lida do JSON:");
        System.out.println(tarefaLida);

    }
}

