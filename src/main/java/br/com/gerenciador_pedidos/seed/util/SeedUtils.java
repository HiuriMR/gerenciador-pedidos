package br.com.gerenciador_pedidos.seed.util;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SeedUtils {
/*
    // Categoria idempotente
    public static Categoria getOrCreateCategoria(CategoriaRepository repo, String nome, Long id) {
        return repo.findByNome(nome)
                .orElseGet(() -> repo.save(new Categoria(id, nome)));
    }

    // Fornecedores idempotentes com saveAll
    public static void saveFornecedoresIfNotExists(FornecedorRepository repo, List<Fornecedor> fornecedores) {
        // Filtra os que ainda não existem
        List<Fornecedor> novos = fornecedores.stream()
                .filter(f -> repo.findByNome(f.getNome()).isEmpty())
                .collect(Collectors.toList());

        if (!novos.isEmpty()) {
            repo.saveAll(novos);
        }

        // Retorna todos os fornecedores persistidos (com id)
        return fornecedores.stream()
                .map(f -> repo.findByNome(f.getNome())
                        .orElseThrow(() -> new RuntimeException("Erro ao salvar fornecedor: " + f.getNome())))
                .collect(Collectors.toList());
    }

    // Produtos idempotentes com saveAll
    public static void saveProdutosIfNotExists(ProdutoRepository repo, List<Produto> produtos) {
        List<Produto> novos = produtos.stream()
                .filter(p -> !repo.existsByNome(p.getNome()))
                .collect(Collectors.toList());

        if (!novos.isEmpty()) {
            repo.saveAll(novos);
        }
    }*/
}
