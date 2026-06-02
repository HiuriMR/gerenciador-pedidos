package br.com.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

/**
 * Entidade Pedido.
 * Observações:
 * - ManyToMany é LAZY por padrão: acessar getProdutos() fora de uma sessão ativa causa LazyInitializationException.
 * - Ao salvar um Pedido que referencia Produtos, os Produtos devem estar persistidos (ou usar cascade = PERSIST).
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private Long id; // aqui o id é controlado manualmente; se preferir auto, use @GeneratedValue

    private LocalDate data;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    public Pedido(Long id, LocalDate data){
        this.id = id;
        this.data = data;
    }

    protected Pedido(){}

    public Long getId(){ return id; }
    public LocalDate getData(){ return data; }

    // Retorna a coleção; se LAZY e sessão fechada, acessar causa LazyInitializationException.
    public List<Produto> getProdutos(){ return produtos; }

    // CORREÇÃO: atribui o parâmetro ao campo.
    public void setProdutos(List<Produto> produto1) {
        this.produtos = produto1;
    }
}
