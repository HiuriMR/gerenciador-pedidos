package br.com.gerenciador_pedidos.principal;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Pedido;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.PedidoRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

public class Principal {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private PedidoRepository pedidoRepository;
    public Principal(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void exibir(){

        // Criando categorias
        Categoria categoriaEletronicos = new Categoria(null, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(null, "Livros");

        // Criando produtos e associando às categorias
        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros);

        // Associando produtos às categorias
        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
        categoriaLivros.setProdutos(List.of(produto3, produto4));

        // Salvando categorias (cascateia produtos automaticamente, se configurado)
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        // Testando a persistência e o relacionamento
        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });
    }
}

