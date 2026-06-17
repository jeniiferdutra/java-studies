public class TabuadaMultiplicacao implements Tabuada {
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Override
    public int mostrarTabuada() {
        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
        return 0;
    }
}
