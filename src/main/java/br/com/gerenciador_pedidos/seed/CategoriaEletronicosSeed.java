package br.com.gerenciador_pedidos.seed;

import br.com.gerenciador_pedidos.model.Categoria;
import br.com.gerenciador_pedidos.model.Fornecedor;
import br.com.gerenciador_pedidos.model.Produto;
import br.com.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class CategoriaEletronicosSeed {

    public static void insert(CategoriaRepository categoriaRepository,
                              FornecedorRepository fornecedorRepository,
                              ProdutoRepository produtoRepository) {

        Categoria categoriaEletronicos = new Categoria(1L, "Eletrônicos");
        categoriaRepository.save(categoriaEletronicos);

        // Fornecedores
        Fornecedor fornecedorSamsung = new Fornecedor("Samsung");
        Fornecedor fornecedorApple = new Fornecedor("Apple");
        Fornecedor fornecedorLG = new Fornecedor("LG");
        Fornecedor fornecedorSony = new Fornecedor("Sony");
        Fornecedor fornecedorDell = new Fornecedor("Dell");
        Fornecedor fornecedorHP = new Fornecedor("HP");
        Fornecedor fornecedorLenovo = new Fornecedor("Lenovo");
        Fornecedor fornecedorAsus = new Fornecedor("Asus");
        Fornecedor fornecedorXiaomi = new Fornecedor("Xiaomi");
        Fornecedor fornecedorMotorola = new Fornecedor("Motorola");

        fornecedorRepository.saveAll(List.of(
                fornecedorSamsung, fornecedorApple, fornecedorLG, fornecedorSony,
                fornecedorDell, fornecedorHP, fornecedorLenovo, fornecedorAsus,
                fornecedorXiaomi, fornecedorMotorola
        ));

        // Produtos (20)
        Produto produto1 = new Produto("Notebook Dell Inspiron", 3500.0, categoriaEletronicos); produto1.setFornecedor(fornecedorDell);
        Produto produto2 = new Produto("Smartphone Samsung Galaxy S23", 4200.0, categoriaEletronicos); produto2.setFornecedor(fornecedorSamsung);
        Produto produto3 = new Produto("Smartphone iPhone 14", 6500.0, categoriaEletronicos); produto3.setFornecedor(fornecedorApple);
        Produto produto4 = new Produto("TV LG 55 Polegadas", 2800.0, categoriaEletronicos); produto4.setFornecedor(fornecedorLG);
        Produto produto5 = new Produto("Console Sony PlayStation 5", 4500.0, categoriaEletronicos); produto5.setFornecedor(fornecedorSony);

        Produto produto6 = new Produto("Notebook HP Pavilion", 3200.0, categoriaEletronicos); produto6.setFornecedor(fornecedorHP);
        Produto produto7 = new Produto("Notebook Lenovo ThinkPad", 4000.0, categoriaEletronicos); produto7.setFornecedor(fornecedorLenovo);
        Produto produto8 = new Produto("Notebook Asus VivoBook", 3100.0, categoriaEletronicos); produto8.setFornecedor(fornecedorAsus);
        Produto produto9 = new Produto("Smartphone Xiaomi Redmi Note 12", 1800.0, categoriaEletronicos); produto9.setFornecedor(fornecedorXiaomi);
        Produto produto10 = new Produto("Smartphone Motorola Edge 40", 2200.0, categoriaEletronicos); produto10.setFornecedor(fornecedorMotorola);

        Produto produto11 = new Produto("Monitor LG UltraWide", 1500.0, categoriaEletronicos); produto11.setFornecedor(fornecedorLG);
        Produto produto12 = new Produto("Caixa de Som Sony Bluetooth", 800.0, categoriaEletronicos); produto12.setFornecedor(fornecedorSony);
        Produto produto13 = new Produto("Drone DJI Mini", 2500.0, categoriaEletronicos); produto13.setFornecedor(fornecedorSamsung);
        Produto produto14 = new Produto("Smartwatch Apple Watch Series 8", 2800.0, categoriaEletronicos); produto14.setFornecedor(fornecedorApple);
        Produto produto15 = new Produto("Impressora HP Deskjet", 600.0, categoriaEletronicos); produto15.setFornecedor(fornecedorHP);

        Produto produto16 = new Produto("Tablet Samsung Galaxy Tab", 1800.0, categoriaEletronicos); produto16.setFornecedor(fornecedorSamsung);
        Produto produto17 = new Produto("Fone de Ouvido Sony WH-1000XM4", 1200.0, categoriaEletronicos); produto17.setFornecedor(fornecedorSony);
        Produto produto18 = new Produto("Notebook Asus ROG Gamer", 7200.0, categoriaEletronicos); produto18.setFornecedor(fornecedorAsus);
        Produto produto19 = new Produto("Notebook Lenovo Yoga", 5000.0, categoriaEletronicos); produto19.setFornecedor(fornecedorLenovo);
        Produto produto20 = new Produto("Smartphone Xiaomi Mi 13", 3500.0, categoriaEletronicos); produto20.setFornecedor(fornecedorXiaomi);

        produtoRepository.saveAll(List.of(
                produto1, produto2, produto3, produto4, produto5,
                produto6, produto7, produto8, produto9, produto10,
                produto11, produto12, produto13, produto14, produto15,
                produto16, produto17, produto18, produto19, produto20));


    }
}
