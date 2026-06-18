import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> funcionarios = new ArrayList<>();
        funcionarios.add("Joao");
        funcionarios.add("Maria");
        funcionarios.add("joao");
        System.out.println(funcionarios);

        Set<String> produtos = new HashSet<>();
        produtos.add("agua");
        produtos.add("coca cola");
        produtos.add("agua");
        System.out.println(produtos);

        Map<Integer, String> clientes = new HashMap<>();
        clientes.put(1, "maria");
        clientes.put(2, "marcos");
        clientes.put(3, "ana");
        System.out.println(clientes);
    }
}