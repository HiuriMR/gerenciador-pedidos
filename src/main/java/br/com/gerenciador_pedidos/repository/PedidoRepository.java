package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório padrão para Pedido.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Override
    @EntityGraph(attributePaths = "produtos")
    List<Pedido> findAll();
}
