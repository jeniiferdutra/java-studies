import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Jenifer Rocha", 6500);
        Funcionario funcionario2 = new Funcionario("Guilherme Diniz", 5500); // salario imutavel atraves do construtor
        funcionario2.setCargo("Vendedor");

        System.out.println("Funcionario tem o nome: " + funcionario2.getNome());
        System.out.println("Funcionario tem o cargo: " + funcionario2.getCargo());
        System.out.println("Funcionario tem o salario: " + funcionario2.getSalario());

        //funcionario2.exibirInformacoes();
        //funcionario2.reajustarSalario(5);
        funcionario2.reajustarSalario(5);
        funcionario2.reajustarSalario(10); // controla o reajuste protegendo a classe
        funcionario2.exibirInformacoes();

        System.out.println("\n---------------------------------------");

        Livro l = new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", 208);
        l.exibirInformacoes();
        Livro f = new Livro("Outlander: a viajante do tempo", "Diana Gabaldon", 752);
        f.exibirInformacoes();

        System.out.println("---------------------------------------");

        Conta saldo = new Conta(5000);
        saldo.exibirSaldo();
        saldo.zerarSaldo();
        saldo.exibirSaldo();

        System.out.println("\n---------------------------------------");

        Aluno aluno1 = new Aluno("Jenifer", 6.5, 7.5);
        aluno1.resultado();

        System.out.println("\n---------------------------------------");

        Carro carro1 = new Carro("Tucson", "IXL569", 2012);

        System.out.println("Carro cadastrado");
        System.out.println("Modelo: " + carro1.getModelo());
        System.out.println("Placa: " + carro1.getPlaca());
        System.out.println("Ano: " + carro1.getAno());

        System.out.println("\n---------------------------------------");

        ArrayList<Contato> contato = new ArrayList<>();

        contato.add(new Contato("João Silva", "(11) 99999-0000"));
        contato.add(new Contato("Jenifer Rocha", "(11) 97721-5764"));
        contato.add(new Contato("Luana Santos", "(21) 98888-0000"));

        System.out.println("Lista de contatos:");
        int indice = 1;
        for(Contato contatos : contato) {
            System.out.printf("%d. %s - %s\n",
                    indice++,
                    contatos.getNome(),
                    contatos.getTelefone());
        }
    }
}