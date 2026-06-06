package br.com.gerenciador_pedidos.principal;

import br.com.gerenciador_pedidos.model.Categoria;
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
import java.util.Scanner;

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
    Scanner leitura = new Scanner(System.in);

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
/*
Criar a derived query correspondente:
1 - Retorne todos os produtos com o nome exato fornecido.
2 - Retorne todos os produtos associados a uma categoria específica.
3 - Retorne produtos com preço maior que o valor fornecido.
4 - Retorne produtos com preço menor que o valor fornecido.
5 - Retorne produtos cujo nome contenha o termo especificado.
6 - Retorne pedidos que ainda não possuem uma data de entrega.
7 - Retorne pedidos com data de entrega preenchida.
8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.
9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.
10 - Retorne a contagem de produtos em uma categoria específica.
11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.
12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.
13 - Retorne pedidos feitos após uma data específica.
14 - Retorne pedidos feitos antes de uma data específica. , 15 - Retorne pedidos feitos em um intervalo de datas.
16 - Retorne os três produtos mais caros.
17 - Retorne os cinco produtos mais baratos de uma categoria.
* */

        var opcao = 1;

        while(opcao!=0){
            mostrarMenu();
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    buscaProdutoPorNome();
                    break;
                case 2:
                    buscaProdutoPorCategoria();
                    break;
                case 3:
                    buscarProdutoPorValor();
                    break;
                case 4:
                    criarPedido();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

        }


    }

    private void mostrarMenu(){
        var menu = """
                Bem vindo! Escolha uma das opções: 
                
                1 - Procure o produto pelo nome
                2 - Pesquise produtos por categoria
                3 - Pesquise produtos a partir de um valor
                4 - Criar pedido
                0 - sair
                """;
        System.out.println(menu);
    }

    private void subMenuValor(){
        var subMenuValor = """
                Escolha uma opção:
                1 - Produtos maiores que um valor
                2 - Produtos menores que um valor
                """;
        System.out.println(subMenuValor);
    }

    //1,5
    private void buscaProdutoPorNome(){
        System.out.println("Digite o nome do produto: ");
        var nomeProduto = leitura.nextLine();
        List<Produto> listaProdutos = produtoRepository.findByNomeContainingIgnoreCase(nomeProduto);
        listaProdutos.forEach(p ->
                System.out.println(p.getNome() + " | Valor " +
                        p.getPreco() + " | Categoria " + p.getCategoria().getNome()));
    }

    //2
    private void buscaProdutoPorCategoria(){
        System.out.println("Digite o nome da categoria desejada: ");
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        listaCategorias.forEach(c ->
                System.out.println(c.getNome()));
        var nomeCategoria = leitura.nextLine();
        List<Produto> listaProdutosPorCategoria = produtoRepository.findByCategoriaNome(nomeCategoria);
        System.out.println("Produtos da categoria " + nomeCategoria);
        listaProdutosPorCategoria.forEach(p ->
                System.out.println(p.getNome() + " | Valor " +
                        p.getPreco() + " | Categoria " + p.getCategoria().getNome()));
    }

    //3,4
    private void buscarProdutoPorValor(){
        subMenuValor();
        var opcao = leitura.nextInt();
        var valor = 0.0;
        List<Produto> listaProdutosPorValor = null;
        if(opcao == 1){
            System.out.println("Digite o valor que deseja filtrar: ");
            valor = leitura.nextDouble();
            listaProdutosPorValor = produtoRepository.findByPrecoGreaterThanEqual(valor);
        }else if (opcao == 2){
            System.out.println("Digite o valor que deseja filtrar: ");
            valor = leitura.nextDouble();
            listaProdutosPorValor = produtoRepository.findByPrecoLessThanEqual(valor);
        }

        listaProdutosPorValor.forEach(p ->
                System.out.println(p.getNome() + " | Valor " + p.getPreco() +
                        " | Categoria " + p.getCategoria().getNome()));

    }

    private void criarPedido(){
        List<Produto> produtos = produtoRepository.findAllBy();
        produtos.forEach(p ->
                System.out.println(p.getNome() + " | Valor " + p.getPreco() +
                        " | Categoria " + p.getCategoria().getNome()));

        System.out.println("Digite o nome do produto que deseja comprar: ");
        var produto = leitura.nextLine();

        Produto produto1 =  produtoRepository.findByNome(produto);

        // Criando pedidos e associando produtos
        Pedido pedido1 = new Pedido(1L, LocalDate.now());
        pedido1.setProdutos(List.of(produto1));
        pedidoRepository.saveAll(List.of(pedido1));

        System.out.println("Pedidos");
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        listaPedidos.forEach(p ->
                System.out.println(p.getProdutos() + " | " + p.getData()));

    }
}
