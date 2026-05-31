package br.com.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity // a classe será uma tabela
@Table(name = "produtos") // o nome da tabela será produtos
public class Produto {
    @Id // a tabela produtos terá uma chave primária do tipo Long
    @GeneratedValue(strategy = GenerationType.IDENTITY) //a chave primária será auto-incremento
    private Long id;
    @Column(nullable = true) // nome deve ser único na tabela e não nulo
    private String nome;
    @Column(name = "valor") //preço será salvo na coluna de nome valor
    private Double preco;

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public Double getPreco(){
        return preco;
    }

}
