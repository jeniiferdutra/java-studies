package com.jenifer.alura_musica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMusica;

    @ManyToOne
    private Artista artista;

    public Musica(){}

    public Musica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public Long getId() {
        return id;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Música:'" + nomeMusica + '\'' +
                ", artista:'" + artista.getNomeArtista();
    }
}
