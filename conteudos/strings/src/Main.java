import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String nome = "Jenifer Rocha";

        String disciplina = "Java e programacao orientada a objetos";

        String curriculo = """
                Formada em Análise e Desenvolvimento de Sistemas e Pós graduada em Engenharia de Software;
                Desenvolvedora backend Java desde 2026;
                """;

        String texto = String.format("Disciplina: %s - %s", disciplina, nome.toUpperCase());
        System.out.println(texto);

        System.out.printf("Nome: %s %nDisciplina: %s", nome.replace("Rocha", "Dutra"), disciplina);

        System.out.println("\n" + curriculo);

        System.out.println("---------------------------------------------------");
        System.out.println("REGEX");

        System.out.println("Meu email é jeniferdutra@gmail.com.br");
        Pattern pattern1 = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher1 = pattern1.matcher(texto);

        if (matcher1.find()) {
            System.out.println(matcher1.group());
        }

        System.out.println(formatarTelefone("11877546833"));

    }

    public static String formatarTelefone(String telefone) {
        String regex = "(\\d{2})(\\d{4,5})(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);

        if (matcher.matches()) {
            return String.format("(%s) %s-%s",
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3));
        }
        return "Numero de telefone inválido";
    }
}
