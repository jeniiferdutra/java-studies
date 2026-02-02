public class Carro {
    // Crie uma classe Carro com métodos para representar um modelo específico ao longo de três anos. Implemente métodos para definir o nome do modelo, os preços médios para cada ano, e calcular e exibir o menor e o maior preço. Adicione uma subclasse ModeloCarro para criar instâncias específicas, utilizando-a na classe principal para definir preços e mostrar informações.

    private String nomeModelo;
    private double precoAno1;
    private double precoAno2;
    private double precoAno3;
    private double precoMedioDeCadaAno;
    private double maiorPreco;
    private double menorPreco;

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public double getPrecoAno1() {
        return precoAno1;
    }

    public void setPrecoAno1(double precoAno1) {
        this.precoAno1 = precoAno1;
    }

    public double getPrecoAno2() {
        return precoAno2;
    }

    public void setPrecoAno2(double precoAno2) {
        this.precoAno2 = precoAno2;
    }

    public double getPrecoAno3() {
        return precoAno3;
    }

    public void setPrecoAno3(double precoAno3) {
        this.precoAno3 = precoAno3;
    }

    public double calcularMedia() {
        return this.precoMedioDeCadaAno = (precoAno1 + precoAno2 + precoAno3) / 3;
    }

    public double getPrecoMedioDeCadaAno() {
        return precoMedioDeCadaAno;
    }

    public double calcularMaiorPreco() {
        this.maiorPreco = precoAno1;
        if (precoAno2 > this.maiorPreco) {
            this.maiorPreco = precoAno2;
        }
        if (precoAno3 > this.maiorPreco) {
            this.maiorPreco = precoAno3;
        }
        return this.maiorPreco;
    }

    public double calcularMenorPreco() {
        this.menorPreco = this.precoAno1;
        if (precoAno2 < this.menorPreco) {
            this.menorPreco = this.precoAno2;
        }
        if (precoAno3 < this.menorPreco) {
            this.menorPreco = precoAno3;
        }
        return this.menorPreco;
    }
}
