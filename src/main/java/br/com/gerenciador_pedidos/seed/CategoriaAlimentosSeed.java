package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class CategoriaAlimentosSeed {

    public static void insert(CategoriaRepository categoriaRepository,
                              FornecedorRepository fornecedorRepository,
                              ProdutoRepository produtoRepository) {
        Categoria categoriaAlimentos = new Categoria(3L, "Alimentos");
        categoriaRepository.save(categoriaAlimentos);

        // Fornecedores
        Fornecedor fornecedorSadia = new Fornecedor("Sadia");
        Fornecedor fornecedorPerdigao = new Fornecedor("Perdigão");
        Fornecedor fornecedorNestle = new Fornecedor("Nestlé");
        Fornecedor fornecedorYoki = new Fornecedor("Yoki");
        Fornecedor fornecedorCamil = new Fornecedor("Camil");
        Fornecedor fornecedorAurora = new Fornecedor("Aurora");
        Fornecedor fornecedorItambe = new Fornecedor("Itambé");
        Fornecedor fornecedorBauducco = new Fornecedor("Bauducco");
        Fornecedor fornecedorVigor = new Fornecedor("Vigor");
        Fornecedor fornecedorPifPaf = new Fornecedor("Pif Paf");

        fornecedorRepository.saveAll(List.of(
                fornecedorSadia, fornecedorPerdigao, fornecedorNestle, fornecedorYoki,
                fornecedorCamil, fornecedorAurora, fornecedorItambe, fornecedorBauducco,
                fornecedorVigor, fornecedorPifPaf
        ));

        // Produtos (20)
        Produto alimento1 = new Produto("Arroz Branco Camil 5kg", 25.0, categoriaAlimentos); alimento1.setFornecedor(fornecedorCamil);
        Produto alimento2 = new Produto("Feijão Carioca Yoki 1kg", 8.0, categoriaAlimentos); alimento2.setFornecedor(fornecedorYoki);
        Produto alimento3 = new Produto("Macarrão Espaguete Nestlé 500g", 6.0, categoriaAlimentos); alimento3.setFornecedor(fornecedorNestle);
        Produto alimento4 = new Produto("Carne Bovina Sadia 1kg", 45.0, categoriaAlimentos); alimento4.setFornecedor(fornecedorSadia);
        Produto alimento5 = new Produto("Frango Congelado Perdigão 1kg", 25.0, categoriaAlimentos); alimento5.setFornecedor(fornecedorPerdigao);

        Produto alimento6 = new Produto("Linguiça Aurora 1kg", 20.0, categoriaAlimentos); alimento6.setFornecedor(fornecedorAurora);
        Produto alimento7 = new Produto("Leite Integral Itambé 1L", 5.0, categoriaAlimentos); alimento7.setFornecedor(fornecedorItambe);
        Produto alimento8 = new Produto("Queijo Mussarela Vigor 500g", 30.0, categoriaAlimentos); alimento8.setFornecedor(fornecedorVigor);
        Produto alimento9 = new Produto("Biscoito Bauducco 200g", 7.0, categoriaAlimentos); alimento9.setFornecedor(fornecedorBauducco);
        Produto alimento10 = new Produto("Presunto Aurora 200g", 12.0, categoriaAlimentos); alimento10.setFornecedor(fornecedorAurora);

        Produto alimento11 = new Produto("Arroz Integral Camil 1kg", 10.0, categoriaAlimentos); alimento11.setFornecedor(fornecedorCamil);
        Produto alimento12 = new Produto("Feijão Preto Yoki 1kg", 9.0, categoriaAlimentos); alimento12.setFornecedor(fornecedorYoki);
        Produto alimento13 = new Produto("Macarrão Penne Nestlé 500g", 7.0, categoriaAlimentos); alimento13.setFornecedor(fornecedorNestle);
        Produto alimento14 = new Produto("Carne Suína Sadia 1kg", 40.0, categoriaAlimentos); alimento14.setFornecedor(fornecedorSadia);
        Produto alimento15 = new Produto("Frango a Passarinho Perdigão 1kg", 28.0, categoriaAlimentos); alimento15.setFornecedor(fornecedorPerdigao);

        Produto alimento16 = new Produto("Linguiça Pif Paf 1kg", 22.0, categoriaAlimentos); alimento16.setFornecedor(fornecedorPifPaf);
        Produto alimento17 = new Produto("Leite Desnatado Itambé 1L", 5.5, categoriaAlimentos); alimento17.setFornecedor(fornecedorItambe);
        Produto alimento18 = new Produto("Queijo Parmesão Vigor 200g", 18.0, categoriaAlimentos); alimento18.setFornecedor(fornecedorVigor);
        Produto alimento19 = new Produto("Bolo Bauducco Chocolate 250g", 12.0, categoriaAlimentos); alimento19.setFornecedor(fornecedorBauducco);
        Produto alimento20 = new Produto("Presunto Sadia 200g", 14.0, categoriaAlimentos); alimento20.setFornecedor(fornecedorSadia);

        produtoRepository.saveAll(List.of(
                alimento1, alimento2, alimento3, alimento4, alimento5,
                alimento6, alimento7, alimento8, alimento9, alimento10,
                alimento11, alimento12, alimento13, alimento14, alimento15,
                alimento16, alimento17, alimento18, alimento19, alimento20
        ));
    }
}
