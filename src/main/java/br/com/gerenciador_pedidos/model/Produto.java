package br.com.gerenciador_pedidos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidade Produto gerenciada pelo JPA/Hibernate.
 * Comentários explicam comportamento relevante do mapeamento.
 */
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique = true cria constraint no banco; tente evitar inserir duplicatas sem checar.
    @Column(nullable = false, unique = true)
    private String nome;

    // coluna 'valor' no banco
    @Column(name = "valor")
    private Double preco;

    // ManyToOne: muitos produtos pertencem a uma categoria.
    // Por padrão ManyToOne é EAGER, então categoria normalmente é carregada junto.
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // ManyToOne para fornecedor; também carregado por padrão.
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    // Construtor para uso em código (antes de persistir)
    public Produto(String nome, Double preco, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Construtor protegido exigido pelo JPA
    protected Produto(){}

    // Getters
    public Long getId(){ return id; }
    public String getNome(){ return nome; }
    public Double getPreco(){ return preco; }
    public Categoria getCategoria(){ return categoria; }
    public Fornecedor getFornecedor(){ return fornecedor; }

    // Setter de categoria: atualiza a referência no objeto em memória
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    // CORREÇÃO IMPORTANTE: atribui o parâmetro ao campo.
    // Se você esquecer de atribuir, o campo fica nulo e o JPA pode persistir um produto sem fornecedor.
    public void setFornecedor(Fornecedor fornecedorTech) {
        this.fornecedor = fornecedorTech;
    }

    // Setters adicionais para permitir alterações antes de persistir
    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(Double preco) { this.preco = preco; }
}
