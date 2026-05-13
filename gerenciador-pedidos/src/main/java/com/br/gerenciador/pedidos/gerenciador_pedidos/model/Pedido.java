package com.br.gerenciador.pedidos.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private Long id;

    private LocalDate data;

    public Pedido() {}

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }
}
