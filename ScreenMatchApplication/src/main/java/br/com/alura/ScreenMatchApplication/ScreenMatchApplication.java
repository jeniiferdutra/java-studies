package br.com.alura.ScreenMatchApplication;

import br.com.alura.ScreenMatchApplication.main.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Autowired
	private Principal main;

	@Override
	public void run(String... args) throws Exception {
		main.exibeMenu();
	}
}
