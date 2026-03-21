package br.com.alura.screenmatch02;

import br.com.alura.screenmatch02.service.ConsumoAPI;
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
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&Season=1&apikey=e5be24ea");
		System.out.println(json);
		json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
	}
}
