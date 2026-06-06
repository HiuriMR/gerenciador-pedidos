package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório padrão para Fornecedor.
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    //CharSequence findByNome(String nome);
}
