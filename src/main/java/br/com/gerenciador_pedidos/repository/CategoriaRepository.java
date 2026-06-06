package br.com.gerenciador_pedidos.repository;

import br.com.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório padrão para Categoria.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    //boolean existsBuNome();
    //Optional<Categoria> findByNome(String nome);
}
