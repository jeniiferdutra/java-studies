import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> funcionarios = new ArrayList<>();
        funcionarios.add("João");
        funcionarios.add("Maria");
        funcionarios.add("Vitor");
        funcionarios.add("Ana");

        System.out.println("Lista de funcionários: " + funcionarios);

        System.out.println("-----------------------------------------");

        List<String> estudades = new LinkedList<>();
        estudades.add("Joana");
        estudades.add("Lucas");
        estudades.add("Pedro");
        estudades.add("Antonio");
        System.out.println("Lista inicial: " + estudades);

        estudades.remove("Pedro");
        System.out.println("Lista após a exclusao: " + estudades);

        System.out.println("-----------------------------------------");

        List<String> funcionariosEmpresa = new LinkedList<>();
        funcionariosEmpresa.add("João");
        funcionariosEmpresa.add("Maria");
        funcionariosEmpresa.add("Ana");
        funcionariosEmpresa.add("Pedro");
        funcionariosEmpresa.add("Antônio");

        System.out.println("A segunda pessoa da lista é: " + funcionariosEmpresa.get(1));
        System.out.println("Total de funcionários: " + funcionariosEmpresa.size());

        System.out.println("-----------------------------------------");

        List<String> eventos = new ArrayList<>();
        eventos.add("IA Conference Brasil");
        eventos.add("AI Summit");
        eventos.add("DevFest");
        eventos.add("Cloud Expo");
        eventos.add("IA Conference Brasil");
        eventos.add("DevFest");

        Set<String> eventosUnicos = new HashSet<>(eventos);

        System.out.println("Lista de eventos: " + eventosUnicos);

        System.out.println("-----------------------------------------");

        Map<Integer, String> livraria = new HashMap<>();
        livraria.put(1, "Lana");
        livraria.put(2, "Abel");
        livraria.put(3, "Sade");

        System.out.println("O nome do cliente com ID 2 é: " + livraria.get(2));

        System.out.println("-----------------------------------------");

        Map<Integer, String> clientes = new HashMap<>();
        clientes.put(1, "Maria");
        clientes.put(2, "Marcos");
        clientes.put(3, "Ana");
        clientes.put(4, "Joana");
        clientes.put(5, "Karen");

        if(clientes.containsKey(6)) {
            System.out.println("O nome do cliente com ID 5 é: " + clientes.get(6));
        } else {
            System.out.println(" Cliente com ID 6 não encontrado.");
        }

        System.out.println("-----------------------------------------");

        List<String> funcionariosRH = List.of("Ana", "Bruno", "Carlos", "Amanda", "Alice", "Daniel", "Caroline");
        List<String> filtroFuncionarios = funcionariosRH.stream()
                .filter(nome -> nome.length() <=5)
                .collect(Collectors.toList());
        System.out.println(filtroFuncionarios);
    }
}