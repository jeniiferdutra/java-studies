//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Guilherme");
        vendedor.setSalarioBase(5500);
        vendedor.setComissao(500);
        System.out.println("O vendedor " + vendedor.getNome() + " teve uma comissao fixa de R$ 500,00, portanto, o salario atualizado é R$ " + vendedor.calcularSalario());

        Gerente gerente = new Gerente();
        gerente.setNome("Jenifer");
        gerente.setSalarioBase(5000);
        gerente.setBonus(1.2);
        System.out.println("O gerente " + gerente.getNome() + " teve uma bonus de 20%, portanto, o salario atualizado é R$ " + gerente.calcularSalario());
    }
}