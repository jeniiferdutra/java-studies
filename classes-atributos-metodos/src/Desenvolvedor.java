public class Desenvolvedor extends Funcionario {
    private String stack;

    // Aproveitar o codigo sem ter a necessidade de reescrever
    public Desenvolvedor(String nome, int salario, String stack) {
        super(nome, salario);
        this.stack = stack;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("\nDesenvolvedor: %s - sálario: %.2f - stack: %s", nome, salario, stack);
    }

    @Override
    public void calcularPLR() {
        System.out.println("PLR do desenvolvedor");
    }
}
