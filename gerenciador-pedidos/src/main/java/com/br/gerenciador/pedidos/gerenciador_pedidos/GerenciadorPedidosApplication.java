package com.br.gerenciador.pedidos.gerenciador_pedidos;

import com.br.gerenciador.pedidos.gerenciador_pedidos.main.Main;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.CategoriaRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.PedidoRepository;
import com.br.gerenciador.pedidos.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(produtoRepository, categoriaRepository, pedidoRepository);
		//main.salvarDados();
		main.exibeMenu();
	}
}
