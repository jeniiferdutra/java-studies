package com.jenifer.alura_musica;

import com.jenifer.alura_musica.main.Main;
import com.jenifer.alura_musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicaApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.exibeMenu();
	}
}
