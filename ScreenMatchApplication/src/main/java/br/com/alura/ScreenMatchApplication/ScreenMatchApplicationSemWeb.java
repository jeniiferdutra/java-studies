//package br.com.alura.ScreenMatchApplication;
//
//import br.com.alura.ScreenMatchApplication.main.Principal;
//import br.com.alura.ScreenMatchApplication.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenMatchApplicationSemWeb implements CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenMatchApplicationSemWeb.class, args);
//	}
//
//	@Autowired
//	private SerieRepository repositorio;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(repositorio);
//		principal.exibeMenu();
//	}
//}
