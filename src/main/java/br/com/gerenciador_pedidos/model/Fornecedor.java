package br.com.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Fornecedor simples.
 * Persistir fornecedores antes de associá-los a produtos evita referências a instâncias transientes.
 */
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    public Fornecedor() {}

    public String getNome() { return nome; }
    public Long getId(){ return id; }
    public void setNome(String nome) { this.nome = nome; }
}
