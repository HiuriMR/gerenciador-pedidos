package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class CategoriaBebidasSeed {

    public static void insert(CategoriaRepository categoriaRepository,
                              FornecedorRepository fornecedorRepository,
                              ProdutoRepository produtoRepository) {

        Categoria categoriaBebidas = new Categoria(4L, "Bebidas");
        categoriaRepository.save(categoriaBebidas);

        // Fornecedores
        Fornecedor fornecedorCocaCola = new Fornecedor("Coca-Cola");
        Fornecedor fornecedorPepsi = new Fornecedor("Pepsi");
        Fornecedor fornecedorAmbev = new Fornecedor("Ambev");
        Fornecedor fornecedorHeineken = new Fornecedor("Heineken");
        Fornecedor fornecedorRedBull = new Fornecedor("Red Bull");
        Fornecedor fornecedorNestleWaters = new Fornecedor("Nestlé Waters");
        Fornecedor fornecedorMonster = new Fornecedor("Monster");
        Fornecedor fornecedorGuaranaAntarctica = new Fornecedor("Guaraná Antarctica");
        Fornecedor fornecedorAbsolut = new Fornecedor("Absolut");
        Fornecedor fornecedorJackDaniels = new Fornecedor("Jack Daniels");

        fornecedorRepository.saveAll(List.of(
                fornecedorCocaCola, fornecedorPepsi, fornecedorAmbev, fornecedorHeineken,
                fornecedorRedBull, fornecedorNestleWaters, fornecedorMonster,
                fornecedorGuaranaAntarctica, fornecedorAbsolut, fornecedorJackDaniels
        ));

        // Produtos (20)
        Produto bebida1 = new Produto("Coca-Cola Lata 350ml", 3.5, categoriaBebidas); bebida1.setFornecedor(fornecedorCocaCola);
        Produto bebida2 = new Produto("Pepsi Lata 350ml", 3.0, categoriaBebidas); bebida2.setFornecedor(fornecedorPepsi);
        Produto bebida3 = new Produto("Cerveja Heineken Long Neck 330ml", 6.0, categoriaBebidas); bebida3.setFornecedor(fornecedorHeineken);
        Produto bebida4 = new Produto("Guaraná Antarctica 2L", 7.0, categoriaBebidas); bebida4.setFornecedor(fornecedorGuaranaAntarctica);
        Produto bebida5 = new Produto("Whisky Jack Daniels 1L", 120.0, categoriaBebidas); bebida5.setFornecedor(fornecedorJackDaniels);

        Produto bebida6 = new Produto("Vodka Absolut 1L", 110.0, categoriaBebidas); bebida6.setFornecedor(fornecedorAbsolut);
        Produto bebida7 = new Produto("Energético Red Bull Lata 250ml", 10.0, categoriaBebidas); bebida7.setFornecedor(fornecedorRedBull);
        Produto bebida8 = new Produto("Energético Monster Lata 473ml", 12.0, categoriaBebidas); bebida8.setFornecedor(fornecedorMonster);
        Produto bebida9 = new Produto("Água Mineral Nestlé 500ml", 2.5, categoriaBebidas); bebida9.setFornecedor(fornecedorNestleWaters);
        Produto bebida10 = new Produto("Cerveja Skol Lata 350ml", 4.0, categoriaBebidas); bebida10.setFornecedor(fornecedorAmbev);

        Produto bebida11 = new Produto("Cerveja Brahma Lata 350ml", 4.0, categoriaBebidas); bebida11.setFornecedor(fornecedorAmbev);
        Produto bebida12 = new Produto("Cerveja Antarctica Lata 350ml", 4.0, categoriaBebidas); bebida12.setFornecedor(fornecedorAmbev);
        Produto bebida13 = new Produto("Cerveja Budweiser Long Neck 330ml", 7.0, categoriaBebidas); bebida13.setFornecedor(fornecedorAmbev);
        Produto bebida14 = new Produto("Cerveja Stella Artois Long Neck 330ml", 8.0, categoriaBebidas); bebida14.setFornecedor(fornecedorAmbev);
        Produto bebida15 = new Produto("Cerveja Corona Long Neck 330ml", 9.0, categoriaBebidas); bebida15.setFornecedor(fornecedorAmbev);

        Produto bebida16 = new Produto("Suco de Laranja Del Valle 1L", 6.0, categoriaBebidas); bebida16.setFornecedor(fornecedorCocaCola);
        Produto bebida17 = new Produto("Suco de Uva Del Valle 1L", 7.0, categoriaBebidas); bebida17.setFornecedor(fornecedorCocaCola);
        Produto bebida18 = new Produto("Água Tônica Schweppes Lata 350ml", 4.5, categoriaBebidas); bebida18.setFornecedor(fornecedorCocaCola);
        Produto bebida19 = new Produto("Pepsi Black Lata 350ml", 3.5, categoriaBebidas); bebida19.setFornecedor(fornecedorPepsi);
        Produto bebida20 = new Produto("Coca-Cola Zero Lata 350ml", 3.5, categoriaBebidas); bebida20.setFornecedor(fornecedorCocaCola);

        produtoRepository.saveAll(List.of(
                bebida1, bebida2, bebida3, bebida4, bebida5,
                bebida6, bebida7, bebida8, bebida9, bebida10,
                bebida11, bebida12, bebida13, bebida14, bebida15,
                bebida16, bebida17, bebida18, bebida19, bebida20
        ));
    }
}
