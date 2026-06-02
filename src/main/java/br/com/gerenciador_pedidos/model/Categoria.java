package br.com.gerenciador_pedidos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade Categoria.
 * - CascadeType.ALL: operações em Categoria (persist/remove) são propagadas aos Produtos.
 * - FetchType.EAGER: produtos são carregados junto com a categoria (cuidado com performance).
 */
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos = new ArrayList<>();

    public Categoria(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    protected Categoria(){}

    public Long getId(){ return id; }
    public String getNome(){ return nome; }
    public List<Produto> getProdutos(){ return produtos; }

    // Ao setar produtos aqui, garantimos consistência do relacionamento definindo a categoria em cada produto.
    public void setProdutos(List<Produto> produtos){
        produtos.forEach(p -> p.setCategoria(this));
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
