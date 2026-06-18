package br.com.alura;

public class Aluno2 extends Pessoa {
    private double nota;

    public Aluno2(String nome, int idade) {
        super(nome, idade);
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void exibirDados() {
        System.out.printf("\nAluno: %s - Idade: %d - Nota: %.2f", nome, idade, nota);
    }
}
