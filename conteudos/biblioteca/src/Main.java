import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> itens = new LinkedList<>();

        itens.add(new Livro("O Alquimista", 3, 1988, "Paulo Coelho"));
        itens.add(new Livro("Mulherzinhas", 2, 1868, "Louisa May Alcott"));
        itens.add(new Livro("Dom Casmurro", 1, 1899, "Machado de Assis"));
        itens.add(new Revista("National Geographic", 2, 2023, 500));
        itens.add(new Revista("Vogue", 3, 1892, 876));

        for (Item lista: itens) {
            lista.exibirDetalhes();
            System.out.println("-----------------------------------");
        }
        Collections.sort(itens);
    }
}