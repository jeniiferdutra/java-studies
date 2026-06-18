import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        Produto produto01 = new Produto("Regata", 90.0, 4);
        Produto produto02 = new Produto("Calça", 199.99, 9);
        Produto produto03 = new Produto("Tenis", 600.0, 6);
        Produto produto04 = new Produto("Cinto", 31.0, 3);

        produtos.add(produto01);
        produtos.add(produto02);
        produtos.add(produto03);
        produtos.add(produto04);

        System.out.println("Lista completa dos produtos: " + produtos.toString());
    }
}