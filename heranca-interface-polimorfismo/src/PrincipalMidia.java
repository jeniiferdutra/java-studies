import br.com.alura.Ebook;
import br.com.alura.Livro;
import br.com.alura.Revista;

public class PrincipalMidia {
    public static void main(String[] args) {

        Livro livro = new Livro("A arvore mais solitaria do mundo", 2024, "Marina salomao");
        Revista revista = new Revista("Vogue", 1995, "hyg8");
        Ebook ebook = new Ebook("Anjos e demonios", 2001, "epub");

        livro.exibirInfo();
        revista.exibirInfo();
        ebook.exibirInfo();
    }
}
