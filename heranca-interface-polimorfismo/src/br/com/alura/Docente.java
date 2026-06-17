package br.com.alura;

public class Docente extends Pessoa {
    private String disciplina;

    public Docente(String nome, int idade) {
        super(nome, idade);
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public void exibirDados() {
        System.out.printf("\nAluno: %s - Idade: %d - Disciplina: %s", nome, idade, disciplina);
    }
}
