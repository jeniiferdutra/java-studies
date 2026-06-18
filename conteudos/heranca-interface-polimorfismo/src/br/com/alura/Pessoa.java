package br.com.alura;

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirDados() {
        System.out.printf("\nAluno: %s - Idade: %d", nome, idade);
    }
}
