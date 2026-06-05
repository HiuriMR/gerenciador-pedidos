package br.com.gerenciador_pedidos.principal;

import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.PedidoRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    }
}
