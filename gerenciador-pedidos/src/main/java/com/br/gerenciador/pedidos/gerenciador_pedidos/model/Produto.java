package com.br.gerenciador.pedidos.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-incremental
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "valor")
    private double preco;

    public Produto() {}

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}
