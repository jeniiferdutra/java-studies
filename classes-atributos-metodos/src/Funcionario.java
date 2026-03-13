public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private int controleReajuste = 0;

    public Funcionario(String nome, int salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void exibirInformacoes() {
        System.out.printf("\nFuncionario: %s - Cargo: %s - Sálario: %.2f",
                            nome, cargo, salario);
    }

    public void reajustarSalario(double percentual) {
        if (controleReajuste >= 1) { // se pode reajustar mais de 1%
            System.out.println("Nao pode fazer reajustes");
        } else {
            controleReajuste++;
            salario += salario * (percentual / 100);
            System.out.printf("\nNovo sálario de %s é %.2f ", nome, salario);
        }
    }
}
