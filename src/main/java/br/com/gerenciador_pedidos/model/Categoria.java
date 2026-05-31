package br.com.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String nome;

    public Categoria(Long id, String nome){
        this.nome = nome;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
}
