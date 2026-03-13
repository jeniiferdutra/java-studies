public class Aluno {
    String nome;
    double nota1;
    double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void resultado() {
        System.out.println("Aluno: " + nome);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        double media = (nota1 + nota2) / 2;
        System.out.printf("Média: %.2f ", media);
        if(media >= 7) {
            System.out.println("\nAprovado");
        } else {
            System.out.println("Reprovado");
        }
    }
}
