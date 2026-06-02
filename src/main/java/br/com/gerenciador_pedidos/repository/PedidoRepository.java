package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório padrão para Pedido.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
