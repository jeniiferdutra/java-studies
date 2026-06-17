package com.br.gerenciador.pedidos.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // nao nulo
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void setProdutos(List<Produto> produtos) {
        produtos.forEach(p -> p.setCategoria(this));
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
