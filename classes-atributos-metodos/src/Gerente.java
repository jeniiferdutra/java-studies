public class Gerente extends Funcionario implements Aprovador{
    private double bonus;

    public Gerente(String nome, int salario) {
        super(nome, salario);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("Gerente: %s - salário %.2f - bonus: %.2f", nome, salario, bonus);
    }

    @Override
    public void calcularPLR() {
        System.out.println("PLR do gerente");
    }

    @Override
    public void aprovarProjeto(String nomeDoProjeto) {
        System.out.printf("\nGerente %s aprovou o projeto %s", nome, nomeDoProjeto);
    }
}
