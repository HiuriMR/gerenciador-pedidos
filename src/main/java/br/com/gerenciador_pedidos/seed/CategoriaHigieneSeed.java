package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class CategoriaHigieneSeed {

    public static void insert(CategoriaRepository categoriaRepository,
                              FornecedorRepository fornecedorRepository,
                              ProdutoRepository produtoRepository) {

        Categoria categoriaHigiene = new Categoria(5L, "Higiene");
        categoriaRepository.save(categoriaHigiene);

        // Fornecedores
        Fornecedor fornecedorColgate = new Fornecedor("Colgate");
        Fornecedor fornecedorOralB = new Fornecedor("Oral-B");
        Fornecedor fornecedorDove = new Fornecedor("Dove");
        Fornecedor fornecedorPantene = new Fornecedor("Pantene");
        Fornecedor fornecedorNivea = new Fornecedor("Nivea");
        Fornecedor fornecedorJohnson = new Fornecedor("Johnson & Johnson");
        Fornecedor fornecedorPalmolive = new Fornecedor("Palmolive");
        Fornecedor fornecedorRexona = new Fornecedor("Rexona");
        Fornecedor fornecedorGillette = new Fornecedor("Gillette");
        Fornecedor fornecedorAlways = new Fornecedor("Always");

        fornecedorRepository.saveAll(List.of(
                fornecedorColgate, fornecedorOralB, fornecedorDove, fornecedorPantene,
                fornecedorNivea, fornecedorJohnson, fornecedorPalmolive,
                fornecedorRexona, fornecedorGillette, fornecedorAlways
        ));

        // Produtos (20)
        Produto higiene1 = new Produto("Creme Dental Colgate Total 90g", 5.0, categoriaHigiene); higiene1.setFornecedor(fornecedorColgate);
        Produto higiene2 = new Produto("Escova de Dentes Oral-B", 12.0, categoriaHigiene); higiene2.setFornecedor(fornecedorOralB);
        Produto higiene3 = new Produto("Shampoo Dove 400ml", 18.0, categoriaHigiene); higiene3.setFornecedor(fornecedorDove);
        Produto higiene4 = new Produto("Condicionador Pantene 400ml", 20.0, categoriaHigiene); higiene4.setFornecedor(fornecedorPantene);
        Produto higiene5 = new Produto("Desodorante Rexona Aerosol", 15.0, categoriaHigiene); higiene5.setFornecedor(fornecedorRexona);

        Produto higiene6 = new Produto("Sabonete Nivea 85g", 4.0, categoriaHigiene); higiene6.setFornecedor(fornecedorNivea);
        Produto higiene7 = new Produto("Shampoo Johnson Baby 200ml", 10.0, categoriaHigiene); higiene7.setFornecedor(fornecedorJohnson);
        Produto higiene8 = new Produto("Sabonete Palmolive 90g", 3.5, categoriaHigiene); higiene8.setFornecedor(fornecedorPalmolive);
        Produto higiene9 = new Produto("Aparelho de Barbear Gillette Mach3", 25.0, categoriaHigiene); higiene9.setFornecedor(fornecedorGillette);
        Produto higiene10 = new Produto("Absorvente Always Noturno 8un", 12.0, categoriaHigiene); higiene10.setFornecedor(fornecedorAlways);

        Produto higiene11 = new Produto("Creme Dental Colgate Sensitive 90g", 6.0, categoriaHigiene); higiene11.setFornecedor(fornecedorColgate);
        Produto higiene12 = new Produto("Escova Dental Oral-B Macia", 13.0, categoriaHigiene); higiene12.setFornecedor(fornecedorOralB);
        Produto higiene13 = new Produto("Shampoo Dove Men 400ml", 19.0, categoriaHigiene); higiene13.setFornecedor(fornecedorDove);
        Produto higiene14 = new Produto("Condicionador Pantene Pro-V 400ml", 22.0, categoriaHigiene); higiene14.setFornecedor(fornecedorPantene);
        Produto higiene15 = new Produto("Desodorante Rexona Clinical", 18.0, categoriaHigiene); higiene15.setFornecedor(fornecedorRexona);

        Produto higiene16 = new Produto("Sabonete Líquido Nivea 250ml", 14.0, categoriaHigiene); higiene16.setFornecedor(fornecedorNivea);
        Produto higiene17 = new Produto("Talco Johnson Baby 100g", 8.0, categoriaHigiene); higiene17.setFornecedor(fornecedorJohnson);
        Produto higiene18 = new Produto("Sabonete Palmolive Naturals 90g", 4.0, categoriaHigiene); higiene18.setFornecedor(fornecedorPalmolive);
        Produto higiene19 = new Produto("Lâmina de Barbear Gillette Fusion", 35.0, categoriaHigiene); higiene19.setFornecedor(fornecedorGillette);
        Produto higiene20 = new Produto("Absorvente Always Ultra 16un", 20.0, categoriaHigiene); higiene20.setFornecedor(fornecedorAlways);

        produtoRepository.saveAll(List.of(
                higiene1, higiene2, higiene3, higiene4, higiene5,
                higiene6, higiene7, higiene8, higiene9, higiene10,
                higiene11, higiene12, higiene13, higiene14, higiene15,
                higiene16, higiene17, higiene18, higiene19, higiene20
        ));
    }
}
