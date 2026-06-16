package com.jenifer.alura_musica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artistas")
public final class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Musica> musica;

    private Artista() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Artista[]";
    }


}
