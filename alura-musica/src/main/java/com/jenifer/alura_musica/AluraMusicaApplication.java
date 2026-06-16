package com.jenifer.alura_musica;

import com.jenifer.alura_musica.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.exibeMenu();
	}
}
