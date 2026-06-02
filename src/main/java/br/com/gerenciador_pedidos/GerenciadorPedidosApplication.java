package br.com.gerenciador_pedidos;

import br.com.gerenciador_pedidos.principal.Principal;
import br.com.gerenciador_pedidos.principal.Principal_teste;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.PedidoRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;
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
	@Autowired
	private FornecedorRepository fornecedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//Principal principal = new Principal(produtoRepository,categoriaRepository,pedidoRepository);
		//principal.exibir();

		Principal_teste principal_teste = new Principal_teste(produtoRepository,categoriaRepository,pedidoRepository,fornecedorRepository);
		principal_teste.principal();
	}
}
