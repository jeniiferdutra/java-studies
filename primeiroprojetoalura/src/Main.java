//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match!");
        System.out.println("Filme: Top Gun: Maverick"); // sout é o atalho para n precisar escrever System...

        int ano = 2022;
        System.out.println("ano de lancamento: " + ano);
        boolean incluidoPlano = false;
        double notaFilme = 8.1;

        boolean igual = (7 == 8); //Nesse caso a variável igual ficará com o valor *false*, pois o valor de b não é igual o valor de a.
        boolean diferente = (9 != 6); //A variável diferente ficará com o valor *true*, pois o valor de b é diferente do valor de c.
        boolean maior = (3 > 5); //A variável maior ficará com o valor *false*, pois o valor de b é menor que o valor de a.
        boolean menorIgual = (4 <= 10); //A variável menorIgual ficará com o valor *true*, pois o valor de b é menor que o valor de c.

        int num = 5;
        int resultado = ++num; //num é incrementado para 6 e depois atribuído a resultado
        System.out.println(num); // imprime 6
        System.out.println(resultado); // imprime 6

        int num02 = 5;
        int resultado02 = num++; //num é atribuído primeiramente à variável resultado e depois incrementado para 6
        System.out.println(num); // imprime 6
        System.out.println(resultado); // imprime 5

    }

}
