package com.jenifer.alura_musica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMusica;

    private String album;

    private String nomeArtista;

    @ManyToOne
    private Artista artista;

    public Musica(){}

    public Musica(String nomeMusica, String album, String nomeArtista) {
        this.nomeMusica = nomeMusica;
        this.album = album;
        this.nomeArtista = nomeArtista;
    }

    public Long getId() {
        return id;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public String getAlbum() {
        return album;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Música:'" + nomeMusica + '\'' +
                ", álbum:'" + album + '\'' +
                ", artista:'" + nomeArtista + '\'';
    }
}
