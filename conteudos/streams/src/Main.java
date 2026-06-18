import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> funcionarios = List.of("Ana", "Bruno", "Carlos", "Amanda");

        // filtrar os funcionarios que comeca com a letra A
        List<String> funcionariosLetraA = funcionarios.stream()
                .filter(f -> f.startsWith("A"))
                .collect(Collectors.toList()); //Jogar na lista de `funcionariosLetraA`

        System.out.println(funcionarios);
        System.out.println(funcionariosLetraA);

        List<Double> valoresVenda = List.of(500.0, 1800.0, 6200.0);

        //Calcular 5% de comissao de cada valor
        List<Double> comissao = valoresVenda.stream()
                .map(v -> v * 0.05)
                .collect(Collectors.toList());
        System.out.println(valoresVenda);
        System.out.println(comissao);

        //Somar todas as vendas
        double totalVendas = valoresVenda.stream()
                .reduce(0.0, Double::sum);
        System.out.println("Total de vendas: " + totalVendas);
    }
}