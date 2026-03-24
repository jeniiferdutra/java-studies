package br.com.alura.screenmatch02;

import br.com.alura.screenmatch02.model.DadosEpisodio;
import br.com.alura.screenmatch02.model.DadosSerie;
import br.com.alura.screenmatch02.model.DadosTemporada;
import br.com.alura.screenmatch02.service.ConsumoAPI;
import br.com.alura.screenmatch02.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=e5be24ea");
		System.out.println(json); // Confirmar que os dados vieram ok
		ConverteDados conversor = new ConverteDados(); // Instacio o Conversor
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class); // Transformar em DadosSerie
		System.out.println(dados);

		json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&Season=1&episode=2&apikey=e5be24ea");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println("Dados do episódio: " + dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&Season=" + i + "&apikey=e5be24ea");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}
