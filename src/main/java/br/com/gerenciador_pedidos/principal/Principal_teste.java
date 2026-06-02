package br.com.gerenciador_pedidos.principal;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Pedido;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.PedidoRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que popula dados de exemplo e executa consultas.
 * - @Transactional mantém a sessão do Hibernate aberta durante todo o método,
 *   evitando LazyInitializationException ao iterar coleções LAZY.
 * - Seed idempotente: verifica existência antes de inserir para evitar duplicate key.
 */
@Component
public class Principal_teste {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final PedidoRepository pedidoRepository;
    private final FornecedorRepository fornecedorRepository;

    public Principal_teste(ProdutoRepository produtoRepository,
                           CategoriaRepository categoriaRepository,
                           PedidoRepository pedidoRepository,
                           FornecedorRepository fornecedorRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public void principal() {
        // 1) Criar categorias (ids manuais neste exemplo)
        Categoria categoriaEletronicos = new Categoria(1L, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(2L, "Livros");
        // Salva categorias (cascade em Categoria persiste produtos se houver)
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        // 2) Criar fornecedores e persistir
        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

        // 3) Criar produtos em memória e associar categoria/fornecedor
        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);

        produto1.setFornecedor(fornecedorTech);
        produto2.setFornecedor(fornecedorTech);
        produto3.setFornecedor(fornecedorLivros);

        // 4) Seed idempotente: salvar apenas produtos que ainda não existem
        List<Produto> todos = List.of(produto1, produto2, produto3);
        List<Produto> novos = todos.stream()
                .filter(p -> !produtoRepository.existsByNome(p.getNome()))
                .collect(Collectors.toList());

        // Persistir novos produtos e obter instâncias gerenciadas
        List<Produto> salvos = produtoRepository.saveAll(novos);

        // Se alguns produtos já existiam, buscar suas instâncias gerenciadas para montar pedidos
        for (Produto p : todos) {
            if (salvos.stream().noneMatch(s -> s.getNome().equals(p.getNome()))) {
                produtoRepository.findByNome(p.getNome()).ifPresent(salvos::add);
            }
        }

        // 5) Criar pedidos usando instâncias gerenciadas (salvos ou buscados)
        Pedido pedido1 = new Pedido(1L, LocalDate.now());
        Pedido pedido2 = new Pedido(2L, LocalDate.now().minusDays(1));

        // Garantir que usamos instâncias gerenciadas (busca por nome)
        Produto pNotebook = produtoRepository.findByNome("Notebook").orElseThrow();
        Produto pLivro = produtoRepository.findByNome("Livro de Java").orElseThrow();
        Produto pSmartphone = produtoRepository.findByNome("Smartphone").orElseThrow();

        pedido1.setProdutos(List.of(pNotebook, pLivro));
        pedido2.setProdutos(List.of(pSmartphone));

        // Salvar pedidos (produtos já persistidos, portanto sem TransientPropertyValueException)
        pedidoRepository.saveAll(List.of(pedido1, pedido2));

        // 6) Consultas e iterações dentro da transação — seguro para acessar coleções LAZY
        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}
