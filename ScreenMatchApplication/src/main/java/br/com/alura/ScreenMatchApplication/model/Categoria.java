package br.com.alura.ScreenMatchApplication.model;

public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    CRIME("Crime"),
    COMEDIA("Comedy"),
    MISTERIO("Mistery"),
    DRAMA("Drama");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if(categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
