import static java.lang.Character.toUpperCase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1 - Crie uma expressão lambda que multiplique dois números inteiros. A expressão deve ser implementada dentro de uma interface funcional com o método multiplicacao(int a, int b).

        Multiplicacao mult = (a, b) -> a * b;
        System.out.println(mult.multiplicacao(5, 3));

        //2 - Descubra se um número é par
        NumeroPar num = (a) -> a % 2 == 0;
        System.out.println(num.numeroPar(11));

        //3 - Crie uma função lambda que receba uma string e a converta para letras maiúsculas.
        Uppercase word = (upper -> upper.toUpperCase());
        System.out.println(word.palavra("jenifer"));
    }
}