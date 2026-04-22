package com.br.jenifer.fipeapi;

import com.br.jenifer.fipeapi.main.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeapiApplication.class, args);
	}

	@Autowired
	private Main main;

	@Override
	public void run(String... args) throws Exception {
		main.exibirMenu();
	}
}
