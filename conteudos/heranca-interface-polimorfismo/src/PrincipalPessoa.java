import br.com.alura.Aluno2;
import br.com.alura.Docente;
import br.com.alura.Pessoa;

public class PrincipalPessoa {
    public static void main(String[] args) {

        Pessoa aluno1 = new Aluno2("Jenifer", 26);
        Pessoa aluno2 = new Aluno2("Guilherme", 32);
        ((Aluno2) aluno1).setNota(8.0);
        ((Aluno2) aluno2).setNota(9.0);

        Pessoa docente1 = new Docente("Gabriela", 21);
        Pessoa docente2 = new Docente("Caio", 24);
        ((Docente) docente1).setDisciplina("Programaçao");
        ((Docente) docente2).setDisciplina("Arquitetura");

        aluno1.exibirDados();
        aluno2.exibirDados();
        docente1.exibirDados();
        docente2.exibirDados();
    }
}
