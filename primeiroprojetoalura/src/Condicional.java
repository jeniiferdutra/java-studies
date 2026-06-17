public class Condicional {
    public static void main(String[] args) {

        int anoDeLancamento = 1990;
        boolean incluidoNoPlano = false;
        double notaFilme = 8.1;
        String tipoPlano = "básico";

        if (anoDeLancamento >= 2022) {
            System.out.println("Lançamentos que os clientes estao curtindo!");
        } else {
            System.out.println("Filme retro que vale a pena assistir!");
        }

        if (incluidoNoPlano && tipoPlano.equals("plus")) {
            System.out.println("Filme liberado!");
        } else {
            System.out.println("Deve pagar a locaçao");
        }

    }
}
