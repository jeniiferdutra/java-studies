package br.com.alura.screenmatch02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Fazer aplicacao de linha de comando
public class Screenmatch02Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch02Application.class, args);
	}

	@Override
	// Vai ser o nosso Main
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring sem web");
	}
}
