package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class CategoriaLivrosSeed {

    public static void insert(CategoriaRepository categoriaRepository,
                              FornecedorRepository fornecedorRepository,
                              ProdutoRepository produtoRepository) {

        Categoria categoriaLivros = new Categoria(2L, "Livros");
        categoriaRepository.save(categoriaLivros);

        // Fornecedores
        Fornecedor fornecedorSaraiva = new Fornecedor("Saraiva");
        Fornecedor fornecedorAmazon = new Fornecedor("Amazon");
        Fornecedor fornecedorCultura = new Fornecedor("Livraria Cultura");
        Fornecedor fornecedorFNAC = new Fornecedor("FNAC");
        Fornecedor fornecedorEstanteVirtual = new Fornecedor("Estante Virtual");
        Fornecedor fornecedorSubmarino = new Fornecedor("Submarino");
        Fornecedor fornecedorAmericanas = new Fornecedor("Americanas");
        Fornecedor fornecedorMartins = new Fornecedor("Martins");
        Fornecedor fornecedorGloboLivros = new Fornecedor("Globo Livros");
        Fornecedor fornecedorCompanhiaDasLetras = new Fornecedor("Companhia das Letras");

        fornecedorRepository.saveAll(List.of(
                fornecedorSaraiva, fornecedorAmazon, fornecedorCultura, fornecedorFNAC,
                fornecedorEstanteVirtual, fornecedorSubmarino, fornecedorAmericanas,
                fornecedorMartins, fornecedorGloboLivros, fornecedorCompanhiaDasLetras
        ));

        // Produtos (20)
        Produto livro1 = new Produto("Dom Casmurro", 35.0, categoriaLivros); livro1.setFornecedor(fornecedorSaraiva);
        Produto livro2 = new Produto("Harry Potter e a Pedra Filosofal", 45.0, categoriaLivros); livro2.setFornecedor(fornecedorAmazon);
        Produto livro3 = new Produto("Clean Code", 120.0, categoriaLivros); livro3.setFornecedor(fornecedorCultura);
        Produto livro4 = new Produto("O Senhor dos Anéis", 90.0, categoriaLivros); livro4.setFornecedor(fornecedorFNAC);
        Produto livro5 = new Produto("O Pequeno Príncipe", 25.0, categoriaLivros); livro5.setFornecedor(fornecedorCompanhiaDasLetras);

        Produto livro6 = new Produto("1984", 40.0, categoriaLivros); livro6.setFornecedor(fornecedorSaraiva);
        Produto livro7 = new Produto("O Hobbit", 50.0, categoriaLivros); livro7.setFornecedor(fornecedorAmazon);
        Produto livro8 = new Produto("Código Da Vinci", 60.0, categoriaLivros); livro8.setFornecedor(fornecedorSubmarino);
        Produto livro9 = new Produto("Game of Thrones - A Guerra dos Tronos", 70.0, categoriaLivros); livro9.setFornecedor(fornecedorAmericanas);
        Produto livro10 = new Produto("A Culpa é das Estrelas", 35.0, categoriaLivros); livro10.setFornecedor(fornecedorMartins);

        Produto livro11 = new Produto("O Alquimista", 30.0, categoriaLivros); livro11.setFornecedor(fornecedorGloboLivros);
        Produto livro12 = new Produto("O Nome do Vento", 85.0, categoriaLivros); livro12.setFornecedor(fornecedorFNAC);
        Produto livro13 = new Produto("Senhora", 28.0, categoriaLivros); livro13.setFornecedor(fornecedorEstanteVirtual);
        Produto livro14 = new Produto("Memórias Póstumas de Brás Cubas", 32.0, categoriaLivros); livro14.setFornecedor(fornecedorSaraiva);
        Produto livro15 = new Produto("Orgulho e Preconceito", 40.0, categoriaLivros); livro15.setFornecedor(fornecedorCompanhiaDasLetras);

        Produto livro16 = new Produto("O Morro dos Ventos Uivantes", 38.0, categoriaLivros); livro16.setFornecedor(fornecedorCultura);
        Produto livro17 = new Produto("O Diário de Anne Frank", 42.0, categoriaLivros); livro17.setFornecedor(fornecedorAmazon);
        Produto livro18 = new Produto("O Silmarillion", 95.0, categoriaLivros); livro18.setFornecedor(fornecedorFNAC);
        Produto livro19 = new Produto("O Senhor das Moscas", 36.0, categoriaLivros); livro19.setFornecedor(fornecedorSubmarino);
        Produto livro20 = new Produto("Grande Sertão: Veredas", 55.0, categoriaLivros); livro20.setFornecedor(fornecedorGloboLivros);

        produtoRepository.saveAll(List.of(
                livro1, livro2, livro3, livro4, livro5,
                livro6, livro7, livro8, livro9, livro10,
                livro11, livro12, livro13, livro14, livro15,
                livro16, livro17, livro18, livro19, livro20
        ));
    }
}
