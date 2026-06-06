package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Profile("dev")
public class SeedData implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;
    private final ProdutoRepository produtoRepository;

    public SeedData(CategoriaRepository categoriaRepository,
                    FornecedorRepository fornecedorRepository,
                    ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Apaga tudo
        produtoRepository.deleteAll();
        fornecedorRepository.deleteAll();
        categoriaRepository.deleteAll();

        // Agora insere novamente
        CategoriaEletronicosSeed.insert(categoriaRepository, fornecedorRepository, produtoRepository);
        CategoriaLivrosSeed.insert(categoriaRepository, fornecedorRepository, produtoRepository);
        CategoriaAlimentosSeed.insert(categoriaRepository, fornecedorRepository, produtoRepository);
        CategoriaBebidasSeed.insert(categoriaRepository, fornecedorRepository, produtoRepository);
        CategoriaHigieneSeed.insert(categoriaRepository, fornecedorRepository, produtoRepository);
    }
}
