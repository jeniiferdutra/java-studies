import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> livro = new ArrayList<>();

        Livro livro1 = new Livro("Outlander", 2016);
        Livro livro2 = new Livro("Gabriela", 1958);
        Livro livro3 = new Livro("Anjos e Demonios", 2000);
        Livro livro4 = new Livro("Pachinko", 2017);
        Livro livro5 = new Livro("Verity", 2018);
        Livro livro6 = new Livro("Mulherzinhas", 1968);
        Livro livro7 = new Livro("Relatos de um gato viajante",2017);

        livro.add(livro1);
        livro.add(livro2);
        livro.add(livro3);
        livro.add(livro4);
        livro.add(livro5);
        livro.add(livro6);
        livro.add(livro7);

        for (Livro item: livro) {
            System.out.println(item);
        }

    }
}