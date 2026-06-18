import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        numeros.stream()
                .filter(e -> e % 2 == 0) // Seleciona itens
                .forEach(System.out::println); // Executa uma ação

        List<String> palavras = Arrays.asList("java", "stream", "lambda");

        palavras.stream()
                .map(p -> p.toLowerCase()) // Transforma itens
                .forEach(System.out::println);
    }
}