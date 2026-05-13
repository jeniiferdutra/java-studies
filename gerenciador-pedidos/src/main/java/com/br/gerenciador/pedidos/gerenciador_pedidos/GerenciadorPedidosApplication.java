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

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Autowired
	private CategoriaRepository Categoriarepositorio;
	private PedidoRepository Pedidorepositorio;
	private ProdutoRepository Produtorepositorio;

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(Categoriarepositorio, Pedidorepositorio, Produtorepositorio);
		main.salvarDados();
	}
}
