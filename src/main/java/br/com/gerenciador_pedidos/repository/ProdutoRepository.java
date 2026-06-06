package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório de Produto com métodos úteis para seed idempotente.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllBy();
    Produto findByNome(String nome);
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaNome(String categoriaNome);
    List<Produto> findByPrecoGreaterThanEqual(Double preco);
    List<Produto> findByPrecoLessThanEqual(Double preco);

}
