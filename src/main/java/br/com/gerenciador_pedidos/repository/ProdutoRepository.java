package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório de Produto com métodos úteis para seed idempotente.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByNome(String nome);
    Optional<Produto> findByNome(String nome);
}
